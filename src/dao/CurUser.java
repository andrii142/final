package dao;

import model.User;

//http session emulator
public class CurUser {
    private static User curUser = null;

    public static User getCurUser() {
        return curUser;
    }

    public static void setCurUser(User curUser) {
        CurUser.curUser = curUser;
    }
}
