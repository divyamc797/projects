package com.divya.practices.comparableSample;

//single property sort
public class Employee implements Comparable<Employee> {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o1) {
        return this.age - o1.age;
    }
}
