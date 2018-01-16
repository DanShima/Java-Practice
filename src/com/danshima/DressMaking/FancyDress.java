package com.danshima.DressMaking;

import com.danshima.DressMaking.Dress;
import com.danshima.DressMaking.DressFormat;

public class FancyDress implements DressFormat {
    public String print(Dress dress){
        String description = dress.getPrice() > 100 ? "expensive" : "affordable";
        return "An " + description + " " + dress.getColor() + " dress";
    }
    public boolean make(Dress dress){
        return dress.getPrice() > 200;
    }
}
