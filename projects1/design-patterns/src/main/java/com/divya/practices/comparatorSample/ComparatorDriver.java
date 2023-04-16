package com.divya.practices.comparatorSample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorDriver {

    public static void main(String[] args) {
        Employee employee1 = new Employee("divya", 25, 200000000);
        Employee employee2 = new Employee("bhanu", 26, 20000);
        Employee employee3 = new Employee("dihan", 1, 200000);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        Collections.sort(employees, ((o1, o2) -> o1.getAge()- o2.getAge()));
        Collections.sort(employees, new SalaryComparator());
    }
}
