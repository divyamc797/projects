package com.divya.divyaworkbook.workbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int age;
    private List<Address> addresses;

    public void print() {
        System.out.println(name + " " + age);
    }
}
