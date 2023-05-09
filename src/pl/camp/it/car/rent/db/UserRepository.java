package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.User;

import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    private static final UserRepository instance = new UserRepository();

    private UserRepository() {}
    /*public UserRepository() {
        this.users.put("admin", new User("admin", "54e3353920c4496ca0cdd7ad5cf2b648"));
        this.users.put("janusz", new User("janusz", "3c94f62f3988095764806e38e30bbfb9"));
    }*/

    public User findUserByLogin(String login) {
        /*for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;*/

        return this.users.get(login);
    }

    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

    public Collection<User> getUsers() {
        return this.users.values();
    }

    public static UserRepository getInstance() {
        return instance;
    }
}
