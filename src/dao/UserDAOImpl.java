package dao;

import model.Room;
import model.User;

public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    private static UserDAOImpl userDAO;

    public static UserDAOImpl getUserDAO() {
        if (userDAO == null)
            userDAO = new UserDAOImpl();
        return userDAO;
    }

    @Override
    public User register(User user) {
        return save(user);
    }
}
