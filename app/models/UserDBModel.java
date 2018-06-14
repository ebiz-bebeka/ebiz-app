package models;

import java.util.HashMap;
import java.util.Map;

public class UserDBModel {

    private static Map<String, UserModel> userinfos = new HashMap<String, UserModel>();
    static
    {
        userinfos.put("test@wp.pl", new UserModel("test", "test@wp.pl","pass"));
    }

    public static void addUserInfo(String name, String email, String password) {
        userinfos.put(email, new UserModel(name, email, password));
    }


    public static boolean isUser(String email) {
        return userinfos.containsKey(email);
    }

    public static UserModel getUser(String email) {
        return userinfos.get((email == null) ? "" : email);
    }

    public static boolean isValid(String email, String password) {
        return ((email != null)
                &&
                (password != null)
                &&
                isUser(email)
                &&
                getUser(email).getPassword().equals(password));
    }
}