package org.example;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class CsvService {

    public List<Employee> readEmployeesFromCsv(String filePath) {
        try {
            return new CsvToBeanBuilder<Employee>(new FileReader(filePath))
                    .withType(Employee.class) // Maps to the employee class
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading CSV file: " + e.getMessage());
        }
    }
}

