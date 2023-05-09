package pl.camp.it.car.rent.core;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.db.UserRepository;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

public class Authenticator {

    private static final Authenticator instance = new Authenticator();
    private final GUI gui = GUI.getInstance();
    private final UserRepository usersDatabase = UserRepository.getInstance();
    private final String seed = "Ba7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";

    private Authenticator() {}

    public boolean authenticate() {
        int counter = 0;
        while (counter < 3) {
            User userFromGui = gui.readLoginAndPassword();
            User userFromDb = usersDatabase.findUserByLogin(userFromGui.getLogin());
            if(userFromDb != null &&
                    userFromDb.getPassword().equals(
                            DigestUtils.md5Hex(userFromGui.getPassword() + seed))) {
                return true;
            }

            System.out.println("Incorrect login or password !!");
            counter++;
        }

        return false;
    }

    public static Authenticator getInstance() {
        return instance;
    }
}
