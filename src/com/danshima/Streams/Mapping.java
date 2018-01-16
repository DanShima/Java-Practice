package com.danshima.Streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Mapping {
    public static void main(String...args){
        // map: return a list of the number of characters for each word
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        //converts each word into an array of individual letters
        words.stream()
                //flattens each generated stream into a single stream
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        //return a list of the square of each number
        List<Integer> numberInSquares =
                numbers1.stream()
                .map(n -> n*n)
                .collect(toList());
        System.out.println(numberInSquares);

        //return all pairs of numbers using two list of numbers
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList()); //terminal operation so forEach is separated
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
    }

