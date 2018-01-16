package com.danshima.DressMaking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class FilterDress {
    public static void main(String[] args) {
        //simple example of lambda
        Runnable r = () -> System.out.println("test!");
        r.run();

        List<Dress> wardrobe = Arrays.asList(new Dress("Ivy","red", 80), new Dress("Missguided", "silver", 2300),
                new Dress("Mango","white", 69));

        //sort the dresses
        wardrobe.sort(new DressComparator());
        System.out.println(wardrobe);
        //reshuffle and sort again
        wardrobe.set(1, new Dress("Gucci","orange", 39));
        wardrobe.sort(comparing(Dress::getPrice));
        System.out.println(wardrobe);

        printDress(wardrobe, new SimpleDress());
        printDress(wardrobe, new FancyDress());

        List<Dress> result = filter(wardrobe, new SimpleDress());
        System.out.println(result);


        List<String> newList = wardrobe.stream()
                .filter(dress -> dress.getPrice() < 100) //select dresses that are below 100 euro
                .sorted(comparing(Dress::getPrice)) //sort them by price
                .map(Dress::getBrand) //extract the names of dresses
                .collect(toList()); //store all those names in a list
        System.out.println(newList);


    }
    public static void printDress(List<Dress> wardrobe, DressFormat format){
        for(Dress dress: wardrobe){
            String output = format.print(dress);
            System.out.println(output);
        }
    }


    public static List<Dress> filter(List<Dress> wardrobe, DressFormat format){
        List<Dress> result = new ArrayList<>();
        for(Dress dress : wardrobe){
            if(format.make(dress)){
                result.add(dress);
            }
        }
        return result;
    }
    static class DressComparator implements Comparator<Dress> {
        public int compare(Dress a, Dress b){
            Integer i = a.getPrice();
            return i.compareTo(b.getPrice());
        }
    }
}