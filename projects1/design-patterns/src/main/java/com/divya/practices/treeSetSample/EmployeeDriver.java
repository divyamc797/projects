package com.divya.practices.treeSetSample;

import java.util.*;

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "abc");
        Employee employee1 = new Employee(10, "bcd");
        Employee employee3 = new Employee(2, "nb");


        var employeeSet = new TreeSet<>();
        employeeSet.add(employee);
        employeeSet.add(employee1);


//        List<Integer> list = Arrays.asList(10, 20, 30); // both method used to create list
        var list = List.of(10, 20, 30); //to create and intilize list - unmodifiable list// java 11
        list.stream().mapToInt(Integer::intValue).average();

        Map.of("string", 89, "jik", 9);// to create and intilize map - unmodifiable map //java 11

//        Java 11 -  adds a few new methods to the String class: isBlank
// jav 11 - var keyword, instead of specifying the data tyoe. complier it self predict data type based on the value assigned.

    }
}
