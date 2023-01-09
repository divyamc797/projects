package com.divya.learning.examples.optionalExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class HandOn {

    /**
     * Optional -> ofNullable, of, stream <- one more obj, list, set, map<k, v>
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
//    String s = null;

//    if(s != null) {
//      System.out.println(s);
//    } else {
//      System.out.println("Object is empty");
//    }

//    Optional<String> optionalS = Optional.ofNullable(s); //Optional.of(s);
//    optionalS
//        .ifPresent(x ->
//        System.out.println(x));

//    String result = Optional.ofNullable(s)
//        .map(x -> x.toUpperCase())
//        .orElseThrow(() -> new Exception("object is empty"));

//    System.out.println(Optional.ofNullable(s)
//        .map(x -> x.toUpperCase())
//        .orElseThrow(() -> new Exception("object is empty")));

//    Student1 student1 = null;
//    Optional.of(student1)
//        .ifPresent(s1 -> System.out.println(s1.getName()));

//    List<Student1> list = new ArrayList<>();
//    list.add(new Student1(15, "bhanu"));
//    list.add(new Student1(30, "xyz"));

        List<Student1> list = Arrays.asList(new Student1(35, "bhanu"),
                new Student1(30, "xyz"));

//    for (Student1 s : list) {
//      if (s.getAge() > 25) {
//        System.out.println(s.getName());
//      }
//    }

//    list.stream()
//        .filter(std -> std.getAge() > 25)
//        .forEach(x -> {
//          Optional.ofNullable(x.getName())
//              .map(name -> name.toUpperCase())
//              .ifPresent(name -> System.out.println(name));
//        });

//    list.stream()
//        .filter(s -> s.getName().equals("bhanu"))
//        .findFirst()
//        .ifPresent(s -> System.out.println(s.getAge()));

//    Map<String, Student1> map = new HashMap<>();
//    map.put("bhanu", new Student1(35, "bhanu"));
//    map.put("xyz", new Student1(30, "xyz"));
//
//    Optional.ofNullable(map.get("bhanu1"))
//        .ifPresent(x -> System.out.println(x.getAge()));

        Student1 ss = new Student1(35, "bhanu");
        if (ss.getName().equals("bhanu") && ss.getAge() > 25) {
            System.out.println("Yes its !present");
        }
    }


    @AllArgsConstructor
    @Getter
    @Setter
    static class Student1 {

        int age;
        String name;
    }
}
