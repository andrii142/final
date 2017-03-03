package main;

import dao.*;
import model.Hotel;
import model.Room;
import model.User;

import java.util.List;
import java.util.Map;

public class Controller {
    private HotelDAO hotelDAO = HotelDAOImpl.getHotelDao();
    private RoomDAO roomDAO = RoomDAOImpl.getRoomDAO();

    //test travis


    public List<Hotel> findHotelByName(String hotelName) {
        return hotelDAO.findByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String city) {
        //TODO chech if logged in
        return hotelDAO.findByCity(city);
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        User curUser = CurUser.getCurUser();

        if (curUser == null || curUser.getId() != userId) {
            System.err.println("You can't book the room");
            return;
        }

        roomDAO.bookRoom(roomId, hotelId);
    }

    public void cancelReservation(long roomId, long userId, long hotelId) {
        User curUser = CurUser.getCurUser();

        if (curUser == null || curUser.getId() != userId) {
            System.err.println("You can't book the room");
            return;
        }

        roomDAO.cancelReservation(roomId, hotelId);
    }


    public List<Room> findRoom(Map<String, String> params) {
        //{"floor" : "3"}
        //{"price" : "100"}

        return roomDAO.roomsByParameters(params);
    }

}
