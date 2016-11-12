package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private long id;
    private String hotelName;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String hotelName, String country, String city, String street) {
        this.id = id;
        this.hotelName = hotelName;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getHotelName() {
        return hotelName;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
