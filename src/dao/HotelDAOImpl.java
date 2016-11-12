package dao;

import model.Hotel;

import java.util.List;
import java.util.stream.Collectors;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> implements HotelDAO {
    private static HotelDAOImpl hotelDAO;

    public static HotelDAO getHotelDao() {
        if (hotelDAO == null)
            hotelDAO = new HotelDAOImpl();
        return hotelDAO;
    }


    @Override
    public List<Hotel> findByCity(final String city) {
        return getAll().stream().
                filter(h -> h.getCity() != null && h.getCity().equals(city)).
                collect(Collectors.toList());
    }

    @Override
    public List<Hotel> findByName(String name) {
        return getAll().stream().
                filter(h -> h.getHotelName() != null && h.getHotelName().equals(name)).
                collect(Collectors.toList());
    }
}
