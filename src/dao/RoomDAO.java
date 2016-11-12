package dao;

import model.Hotel;
import model.Room;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public interface RoomDAO {

    void bookRoom(long roomId, long hotelId);

    void cancelReservation(long roomId, long hotelId);

    List<Room> roomsByParameters(Map<String, String> params);
}
