package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;

    private List<Room> roomsReserved = new ArrayList<Room>();

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Room> getRoomsReserved() {
        return roomsReserved;
    }

    public void addRoomToReserved(Room room) {
        this.roomsReserved.add(room);
    }
}
