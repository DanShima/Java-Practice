package com.danshima.TripBooking;

public class Traveller {
    private String name;
    private String city;

    public Traveller(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

    public String toString(){
        return this.name + " from " + this.city;
    }
}
