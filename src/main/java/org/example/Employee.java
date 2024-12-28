package org.example;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    @CsvBindByName(column = "Id")
    private String id;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Surname")
    private String surname;

    @CsvBindByName(column = "Division")
    private String division;

    @CsvBindByName(column = "Manager")
    private String manager;

    @CsvBindByName(column = "Gender")
    private String gender;

    @CsvBindByName(column = "Ethnicity")
    private String ethnicity;

    @CsvBindByName(column = "Disability")
    private String disability;

    @CsvBindByName(column = "Veteran")
    private String veteran;

    @CsvBindByName(column = "Age")
    private Integer age;

    @CsvBindByName(column = "Nationality")
    private String nationality;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", division='" + division + '\'' +
                ", manager='" + manager + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", disability='" + disability + '\'' +
                ", veteran='" + veteran + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public String getDisability() {
        return disability;
    }

    public String getDivision() {
        return division;
    }

    public String getManager() {
        return manager;
    }

    public String getGender() {
        return gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getVeteran() {
        return veteran;
    }

    public String getId() {
        return id;
    }
}
