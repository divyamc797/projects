package com.divya.divyaworkbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceStudentMapper {
//    public List<Resource> StudentToResouceMapper(List<Student> students) {
//        List<Resource> resources = new ArrayList<>();
//        for (Student student : students) {
//            Resource r = new Resource();
//            r.setResourceName(student.getName());
//            r.setResourceAge(student.getAge());
//            resources.add(r);
//        }
//        return resources;
//    }

    public List<Resource> StudentToResouceMapper(List<Student> students) {
        return students.stream()
                .map(x -> new Resource(x.getName(), x.getAge()))
                .collect(Collectors.toList());
    }

    public List<Student> resourceToStudent(List<Resource> resources) {
        return resources.stream()
                .map(x -> new Student(x.getResourceName(), x.getResourceAge()))
                .collect(Collectors.toList());
    }
}
