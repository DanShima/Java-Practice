package com.danshima.TripBooking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Filtering {
    public static void main(String... args) {
        Traveller dan = new Traveller("Danning", "Munich");
        Traveller sam = new Traveller("Sam", "Kiev");
        Traveller alan = new Traveller("Alan", "Tokyo");
        Traveller baka = new Traveller("Bakasan", "Tokyo");

        List<Trip> trips = Arrays.asList(
                new Trip(alan, "Stockholm", 300, 7),
                new Trip(dan, "Shanghai", 1000, 14),
                new Trip(dan, "Seoul", 2000, 20),
                new Trip(sam, "Amsterdam", 80, 4),
                new Trip(baka, "London", 100, 3),
                new Trip(baka, "Riga", 200, 7)
        );

        //find all trips with 7 days and sort by price
        List<Trip> trip7Days =
                trips.stream()
                .filter(trip -> trip.getDuration() == 7)
                .sorted(comparing(Trip::getPrice))
                .collect(toList());
        System.out.println(trip7Days);

        //filter out the unique cities where the travellers come from
        Set<String> citiesOfOrigin =
                trips.stream()
                .map(trip ->trip.getTraveller().getCity())
                .collect(Collectors.toSet()); //can also use distinct() if it's a list
        System.out.println(citiesOfOrigin);

        //find all travellers from Tokyo and sort them by name
        List<Traveller> travellersTokyo =
                trips.stream()
                .map(Trip::getTraveller)
                .filter(traveller -> traveller.getCity().equals("Tokyo"))
                .distinct()
                .sorted(comparing(Traveller::getName))
                .collect(toList());
        System.out.println(travellersTokyo);

        //find out if a traveller is from Berlin
        boolean kievOrigin =
                trips.stream()
                .anyMatch(trip -> trip.getTraveller().getCity().equals("Berlin"));
        System.out.println(kievOrigin);

        //return a string of all travellers' names sorted alphabetically
        String travellerNames =
                trips.stream()
                .map(trip -> trip.getTraveller().getName())
                .distinct()
                .sorted()
                .collect(joining(" ")); //separate the names with a space
        System.out.println(travellerNames);

        // What's the most expensive trip?
        int mostExpensiveTrip =
                trips.stream()
                        .map(Trip::getPrice)
                        .reduce(0, Integer::max);
        System.out.println(mostExpensiveTrip);

        //now the cheapest
        Optional<Trip> cheapest =
                trips.stream()
                .min(comparing(Trip::getPrice));
        System.out.println(cheapest);

        //Group a list of trips by their travellers
        Map<Traveller, List<Trip>> tripsByTraveller =
                trips.stream().collect(groupingBy(Trip::getTraveller));
        System.out.println(tripsByTraveller);

        long howManyTrips = trips.stream().count();
        System.out.println("the number of trips is " + howManyTrips);

        String allCitiesInString = trips.stream().map(Trip::getCity).collect(joining(", "));
        System.out.println(allCitiesInString);



    }

    public boolean isPrime(int number){
        return IntStream.range(2, number) //generate numbers t/m 2 but excluding number
                .noneMatch(i -> number % i == 0);
    }

    /**
     * check for prime numbers
     * limit the number of divisors to be tested against
     * the candidate prime to those not bigger than the square root of the candidate
     *  @param number
     * @return true if the candidate isnt divisible for any of the numbers in the stream
     */

    public boolean isPrimeOptimal(int number){
        int numberSquareRoot = (int) Math.sqrt((double) number);
        return IntStream.rangeClosed(2, numberSquareRoot)
                        .noneMatch(i -> number % i == 0);
    }

    /**
     * partitioning the first n numbers into prime and non-primes
     * @param n
     * @return
     */

    public Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(number -> isPrime(number)));
    }





}
