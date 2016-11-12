package model;

public class Room {
    private long id;
    private int price;
    private Currency currency;
    private int floor;
    private boolean withView;
    private boolean withBalcony;
    private Hotel hotel;

    private User userReserved;

    public Room(long id, int price, Currency currency, int floor, boolean withView, boolean withBalcony, Hotel hotel) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.floor = floor;
        this.withView = withView;
        this.withBalcony = withBalcony;
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isWithView() {
        return withView;
    }

    public boolean isWithBalcony() {
        return withBalcony;
    }

    public long getId() {
        return id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }
}
