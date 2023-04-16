package com.divya.designpatterns.creationalPatterns.builder;

public class Student {
    private int id;
    private String name;

    //    public Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private int id;
        private String name;

        public StudentBuilder id(int id) {
            this.id = id;
            return this;
        }

    }
}


