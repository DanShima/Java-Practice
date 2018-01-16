package com.danshima.DressMaking;

public class Dress {
    private String color;
    private int price;
    private String brand;

    public Dress(String name, String color, int price){
        this.brand = name;
        this.color = color;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
        return "Dress " + brand + ": " + "color = " + color + ", " + "price = " + price + ". ";
    }
}
