package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.User;

public class UserRepository {
    private final User[] users = new User[2];

    public UserRepository() {
        this.users[0] = new User("admin", "54e3353920c4496ca0cdd7ad5cf2b648");
        this.users[1] = new User("janusz", "3c94f62f3988095764806e38e30bbfb9");
    }

    public User findUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }
}
