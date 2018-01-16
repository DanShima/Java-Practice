package com.danshima.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Finding {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //find the first square that is divisible by 3
        Optional<Integer> firstSquareDivisibleByThree =
                numbers.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);

        //reduce combines each element repeatedly until the stream is reduced to a single value
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        //OR int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Compute maxima: " + max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("Compute minima: " + min);

    }
}
