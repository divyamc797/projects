package com.divya.practices;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class LambdaWithAggregate {
    public static void main(String[] args) {
        //for List of integer
        List<Integer> listOfInteger = Arrays.asList(2, 4, 6, 8);
        int sum1 = listOfInteger.stream().mapToInt(value -> value.intValue()).sum();
        listOfInteger.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
        System.out.println(sum1);

        //Array of Integer
        int[] intArr = {2, 4, 6, 1};

        int sum = Arrays.stream(intArr).sum();
        System.out.println(sum);

        OptionalDouble average = Arrays.stream(intArr).average();
        System.out.println(average);

        double avg = IntStream.of(intArr).average().getAsDouble(); // best practice to use IntStream
        System.out.println(avg);


    }

}
