package org.example;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestService {

    // Method to get gender-based percentage for managers
    public String getManagersGenderFormattedPercentage(List<Employee> employees) {
        long totalManagers = employees.size(); // No need to filter by manager, as the API already returns only managers

        long maleManagers = employees.stream()
                .filter(emp -> "Male".equalsIgnoreCase(emp.getGender()))
                .count();

        long femaleManagers = employees.stream()
                .filter(emp -> "Female".equalsIgnoreCase(emp.getGender()))
                .count();

        if (totalManagers == 0) {
            return "0.00% of managers are male\n0.00% of managers are female";
        }

        double malePercentage = ((double) maleManagers / totalManagers) * 100;
        double femalePercentage = ((double) femaleManagers / totalManagers) * 100;

        return String.format("%.2f%% of managers are male\n and %.2f%% of managers are female", malePercentage, femalePercentage);
    }
}
