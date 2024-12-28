package org.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RestService {

    private final CsvService csvService;

    public RestService(CsvService csvService) {
        this.csvService = csvService;
    }

    public List<Employee> getManagers(String filePath) {
        List<Employee> employees = csvService.readEmployeesFromCsv(filePath);

        // Filter employees who are managers
        List<Employee> managers = employees.stream()
                .filter(emp -> "Yes".equalsIgnoreCase(emp.getManager()))
                .collect(Collectors.toList());

        return managers;
    }




}
