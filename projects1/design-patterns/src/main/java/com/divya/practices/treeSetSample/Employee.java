package com.divya.practices.treeSetSample;

public class Employee implements Comparable<Employee>{
    int age;
    String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}
