package fr.ynov.users.providers;

import fr.ynov.users.resources.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersProvider {

    private static Map<String, User> allUsers = new HashMap<String, User>();

    public static List<User> getAllUsers() {
        return new ArrayList<User>(allUsers.values());
    }

    public static User findUser(String id){
        if(allUsers.containsKey(id)){
            return allUsers.get(id);
        } else {
            return null;
        }
    }

    public static void createUser(User user) throws Exception {
        if(findUser(user.getEmail()) != null){
            throw new Exception();
        }else {
            allUsers.put(user.getEmail(), user);
        }

    }

    static {
       User user = new User("test","test","test");
       allUsers.put("test",user);
    }
}
