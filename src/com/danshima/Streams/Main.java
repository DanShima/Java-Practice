package com.danshima.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 4, 5);
        numbers.stream()
                .filter(i -> i% 2 == 0)
                .distinct() //only unique elements/no duplicates
                .forEach(System.out::println);

        List<Integer> newNumbers = numbers.stream()
                .filter(i -> i < 4)
                .distinct()
                .limit(3)
                .skip(2)
                .collect(toList());
        System.out.println(newNumbers);

    }
}
