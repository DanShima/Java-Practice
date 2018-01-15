package com.danshima;

public class Dress {
    private String color;
    private int price;
    public Dress(String color, int price){
        this.color = color;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String toString(){
        return "Dress " + "color = " + color + ", " + "price = " + price + ". ";
    }
}
