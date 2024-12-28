package org.example;

import org.example.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dei")
public class EmployeeController {

    private final RestService restService;

    @Autowired
    public EmployeeController(RestService restService) {
        this.restService = restService;
    }


    @GetMapping("/managers")
    public List<Employee> getManagers() {
        String filePath = "/app/DEI.csv";
        return restService.getManagers(filePath); // Return list of managers
    }



}
