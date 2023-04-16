package com.divya.practices.comparableSample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableDriver {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Divya", 25);
        Employee employee2 = new Employee("Bhanuraj", 26);
        Employee employee3 = new Employee("Dihan", 1);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        Collections.sort(employees); //assending order
        Collections.sort(employees, Collections.reverseOrder());//descending order

    }
}
