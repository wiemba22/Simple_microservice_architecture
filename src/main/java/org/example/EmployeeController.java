package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;

@RestController
@RequestMapping("/dei")
public class EmployeeController {

    private final RestService restService;
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeController(RestService restService, RestTemplate restTemplate) {
        this.restService = restService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/veterans-managers")
    public String getVeteransManagersPercentage() {
        String managersApiUrl = "http://manager-service:8082/dei/managers";


        // Update for Docker container name

        try {
            // Fetch the list of managers from the API
            List<Employee> managers = restTemplate.exchange(managersApiUrl, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Employee>>() {}).getBody();

            if (managers == null || managers.isEmpty()) {
                return "No managers data available.";
            }

            // Use the service to filter the veteran managers
            List<Employee> veteranManagers = restService.getVeteranManagers(managers);

            // Calculate the percentage of veteran managers
            double percentage = (veteranManagers.size() * 100.0) / managers.size();

            // Format the percentage to two decimal places
            String formattedPercentage = String.format("%.2f", percentage);

            // Return the response in the desired format
            return formattedPercentage + " % of managers are veterans";
        } catch (ResourceAccessException e) {
            return "Error accessing the managers API: " + e.getMessage();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
