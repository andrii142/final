package dao;

import model.Hotel;
import model.Room;
import model.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RoomDAOImpl extends AbstractDAOImpl<Room> implements RoomDAO {

    private static RoomDAOImpl roomDAO;

    public static RoomDAOImpl getRoomDAO() {
        if (roomDAO == null)
            roomDAO = new RoomDAOImpl();
        return roomDAO;
    }



    @Override
    public void bookRoom(long roomId, long hotelId) {
        Room roomToBook = findRoomById(roomId, hotelId);
        if (roomToBook != null)
            //this rooms can't be reserved before
            roomToBook.setUserReserved(CurUser.getCurUser());
    }

    @Override
    public void cancelReservation(long roomId, long hotelId) {
        Room roomToCancel = findRoomById(roomId, hotelId);
        if (roomToCancel != null)
            roomToCancel.setUserReserved(null);
    }

    private Room findRoomById(long roomId, long hotelId) {
        List<Room> roomsWithIdFound = getAll().stream().
                filter(r -> r.getId() == roomId && r.getHotel().getId() == hotelId).
                collect(Collectors.toList());

        if (roomsWithIdFound.size() != 1) {
            //ideally here system exception should be thrown cos it is bad behaviour
            System.err.println("System error when finding room with" + roomId + ". Found " +
                    roomsWithIdFound.size() + " rooms");
            return null;
        }

        return roomsWithIdFound.get(0);
    }

    @Override
    public List<Room> roomsByParameters(Map<String, String> params) {
        List<Room> roomResults = new ArrayList<>();

        boolean isEqualToParams = true;
        for (Room room : getAll()) {
            for (String paramName : params.keySet()) {
                Field field = findRoomFieldWithName(paramName);
                if (field == null) {
                    System.err.println("System error occurred");
                    return null;
                }

                try {
                    field.setAccessible(true);
                    String value = field.get(room).toString();
                    if (!value.equals(params.get(paramName))) {
                        isEqualToParams = false;
                        break;
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("System error occurred");
                    return null;
                }
            }

            if (isEqualToParams)
                roomResults.add(room);
        }

        return roomResults;
    }

    private Field findRoomFieldWithName(String fieldName) {
        for (Field field : Room.class.getDeclaredFields()) {
            if (fieldName.equals(field.getName()))
                return field;
        }
        return null;
    }
}
