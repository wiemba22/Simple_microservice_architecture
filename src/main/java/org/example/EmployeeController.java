package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestService restService;
    @GetMapping("/managers-gender")
    public String getManagersGenderPercentage() {
        String managersApiUrl = "http://manager-service:8082/dei/managers";

        try {
            // Debugging the URL before calling
            System.out.println("Making GET request to: " + managersApiUrl);
            ResponseEntity<List<Employee>> response = restTemplate.exchange(
                    managersApiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Employee>>() {}
            );

            List<Employee> managers = response.getBody();

            if (managers == null || managers.isEmpty()) {
                return "No managers data available.";
            }

            return restService.getManagersGenderFormattedPercentage(managers);
        } catch (ResourceAccessException e) {
            return "Error accessing the managers API: " + e.getMessage();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

}
