package com.danshima.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 4, 5);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct() //only unique elements/no duplicates
                .forEach(System.out::println);

        List<Integer> newNumbers = numbers.stream()
                .filter(i -> i < 4)
                .distinct()
                .limit(3)
                .skip(2)
                .collect(toList());
        System.out.println(newNumbers);

        //fibonacci
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(t -> System.out.print(t + ", "));

        System.out.println("Next: return the next fibonacci element when it's called");

        IntSupplier fib = new IntSupplier() {
                private int previous = 0;
                private int current = 1;
                public int getAsInt(){
                    int oldPrevious = previous;
                    int nextValue = previous + current;
                    previous = current;
                    current = nextValue;
                    return oldPrevious;
                }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::print);
    }

}
