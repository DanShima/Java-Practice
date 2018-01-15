package com.danshima;

public class SimpleDress implements DressFormat {
    public String print(Dress dress){
        return "A dress of " + dress.getPrice() + " euro.";
    }

    public boolean make(Dress dress){
        return "white".equals(dress.getColor());
    }
}
