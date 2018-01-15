package com.danshima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;


public class FilterDress {
    public static void main(String[] args) {
        //simple example of lambda
        Runnable r = () -> System.out.println("test!");
        r.run();

        List<Dress> wardrobe = Arrays.asList(new Dress("red", 80), new Dress("silver", 2300),
                new Dress("white", 69));

        //sort the dresses
        wardrobe.sort(new DressComparator());
        System.out.println(wardrobe);
        //reshuffle and sort again
        wardrobe.set(1, new Dress("orange", 39));
        wardrobe.sort(comparing(Dress::getPrice));
        System.out.println(wardrobe);

        printDress(wardrobe, new SimpleDress());
        printDress(wardrobe, new FancyDress());

        List<Dress> result = filter(wardrobe, new SimpleDress());
        System.out.println(result);



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
