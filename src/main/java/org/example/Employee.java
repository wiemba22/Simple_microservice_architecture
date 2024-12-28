package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    @CsvBindByName(column = "Id")
    @JsonProperty("id")  // Jackson will map the "id" JSON field to this field
    private String id;

    @CsvBindByName(column = "Name")
    @JsonProperty("name")  // Jackson will map the "name" JSON field to this field
    private String name;

    @CsvBindByName(column = "Surname")
    @JsonProperty("surname")
    private String surname;

    @CsvBindByName(column = "Division")
    @JsonProperty("division")
    private String division;

    @CsvBindByName(column = "Manager")
    @JsonProperty("manager")
    private String manager;

    @CsvBindByName(column = "Gender")
    @JsonProperty("gender")
    private String gender;

    @CsvBindByName(column = "Ethnicity")
    @JsonProperty("ethnicity")
    private String ethnicity;

    @CsvBindByName(column = "Disability")
    @JsonProperty("disability")
    private String disability;

    @CsvBindByName(column = "Veteran")
    @JsonProperty("veteran")
    private String veteran;

    @CsvBindByName(column = "Age")
    @JsonProperty("age")
    private Integer age;

    @CsvBindByName(column = "Nationality")
    @JsonProperty("nationality")
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
