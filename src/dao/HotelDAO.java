package dao;

import model.Hotel;

import java.util.List;

public interface HotelDAO {

    List<Hotel> findByCity(String city);

    List<Hotel> findByName(String name);
}
