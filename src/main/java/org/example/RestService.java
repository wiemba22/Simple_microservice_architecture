package org.example;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestService {

    public List<Employee> getVeteranManagers(List<Employee> managers) {
        // Filter the list of managers to include only veteran managers
        List<Employee> veteranManagers = managers.stream()
                .filter(emp -> "Yes".equalsIgnoreCase(emp.getVeteran())) // Ensure employee is a veteran
                .collect(Collectors.toList());

        return veteranManagers;
    }

}
