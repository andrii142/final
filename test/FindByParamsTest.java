import dao.RoomDAOImpl;
import main.Controller;
import model.Currency;
import model.Hotel;
import model.Room;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByParamsTest {

    @Test
    public void test_find_by_params_successfully() {
        RoomDAOImpl roomDAO = RoomDAOImpl.getRoomDAO();

        Hotel hotel = new Hotel(1002, "Radisson", "Ukraine", "Kiev", "TestStreet");
        Room room = new Room(1001, 1000, Currency.UAH, 3, false, false, hotel);
        roomDAO.save(room);

        Controller controller = new Controller();

        Map<String, String> params = new HashMap<>();
        params.put("price", "1000");


        List<Room> roomList = controller.findRoom(params);

        Assert.assertEquals(1, roomList.size());
        Assert.assertEquals(room, roomList.get(0));
    }

    @Test
    public void test_find_by_params_successfully_but_no_rooms_found() {
        RoomDAOImpl roomDAO = RoomDAOImpl.getRoomDAO();

        Hotel hotel = new Hotel(1002, "Radisson", "Ukraine", "Kiev", "TestStreet");
        Room room = new Room(1001, 1000, Currency.UAH, 3, false, false, hotel);
        Room room1 = new Room(1002, 300, Currency.UAH, 1, false, false, hotel);
        roomDAO.save(room);
        roomDAO.save(room1);

        Controller controller = new Controller();

        Map<String, String> params = new HashMap<>();
        params.put("price", "100");
        params.put("withView", "false");


        List<Room> roomList = controller.findRoom(params);

        Assert.assertEquals(0, roomList.size());
    }
}
