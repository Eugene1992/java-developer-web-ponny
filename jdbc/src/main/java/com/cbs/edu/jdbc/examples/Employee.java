package com.cbs.edu.jdbc.examples;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
}
