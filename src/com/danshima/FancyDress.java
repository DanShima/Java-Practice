package com.danshima;

public class FancyDress implements DressFormat {
    public String print(Dress dress){
        String description = dress.getPrice() > 100 ? "expensive" : "affordable";
        return "An " + description + " " + dress.getColor() + " dress";
    }
    public boolean make(Dress dress){
        return dress.getPrice() > 200;
    }
}
