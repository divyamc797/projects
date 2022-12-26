package com.divya.divyaworkbook.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("abc", 1));
        studentList.add(new Student("xyz", 2));
        studentList.add(new Student("xyz2", 3));
        studentList.add(new Student("xyz3", 4));
        studentList.add(new Student("xyz4", 5));

        //print Student age greater than 3
        List<Student> ageFilteredStudents = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getAge() >= 3) {
                ageFilteredStudents.add(s);
            }
        }
        for (Student s : ageFilteredStudents)
            System.out.println("Student name:" + s.getName());

        //print Student age greater than 4
        List<Student> studentsAgeGreaterThanFour = studentList
                .stream()
                .filter(x -> x.getAge() >= 4)
                .collect(Collectors.toList());

        studentsAgeGreaterThanFour
                .stream()
                .forEach(x -> System.out.println(x.getName()));

        ResourceStudentMapper resourceStudentMapper = new ResourceStudentMapper();

        List<Resource> resources = resourceStudentMapper.StudentToResouceMapper(studentList);
        resources.stream().forEach(x -> System.out.println(x.getResourceName()));

        List<Student> students = resourceStudentMapper.resourceToStudent(resources);
        students.stream().forEach(x -> System.out.println(x.getName()));

//average of age
        studentList.stream()
                .mapToInt(x -> x.getAge())
                .average()
                .ifPresent(x -> System.out.println(x));

        //print max age name
        Student maxStudent = null;
        for (Student s : studentList) {
            if (maxStudent == null) {
                maxStudent = s;
            } else if (s.getAge() > maxStudent.getAge()) {
                maxStudent = s;
            }
        }

        Comparator<Student> comparator = Comparator.comparing(Student::getAge);
        Student maxAge = studentList.stream().max(comparator).get();
        System.out.println("maxAge = " + maxAge.getName());


        //min age name


    }
}

