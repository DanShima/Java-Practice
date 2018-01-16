package com.danshima.TripBooking;

public class Trip {
    private Traveller traveller;
    private String city;
    private int price;
    private int duration;

    public Trip(Traveller traveller, String city, int price, int duration){
        this.traveller = traveller;
        this.city = city;
        this.price = price;
        this.duration = duration;
    }

    public Traveller getTraveller(){
        return this.traveller;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String toString(){
        return "Trip for " + traveller + " to " + city + ", price: " + price + " for " + duration + " days.";
    }
}
