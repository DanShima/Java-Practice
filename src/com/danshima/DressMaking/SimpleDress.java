package com.danshima.DressMaking;

import com.danshima.DressMaking.Dress;
import com.danshima.DressMaking.DressFormat;

public class SimpleDress implements DressFormat {
    public String print(Dress dress){
        return "A dress of " + dress.getPrice() + " euro.";
    }

    public boolean make(Dress dress){
        return "white".equals(dress.getColor());
    }
}
