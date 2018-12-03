package com.cbsystematics.edu.servlets;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Anna", "Smith", 22, 16000, false);
        System.out.println(employee);

        Employee build = Employee.builder().age(2).isMarried(false).build();
        System.out.println(build);
    }
}
