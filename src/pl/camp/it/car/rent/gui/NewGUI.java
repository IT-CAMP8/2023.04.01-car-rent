package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.Scanner;

public class NewGUI implements IGUI {
    private static final NewGUI instance = new NewGUI();

    private NewGUI() {

    }
    private Scanner scanner = new Scanner(System.in);
    public String showMenu() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");

        return scanner.nextLine();
    }

    public void listVehicles() {
        for(Vehicle vehicle : VehicleRepository.getInstance().getVehicles()) {
            System.out.println(vehicle);
        }
    }

    public String readPlate() {
        System.out.println("Plate:");
        return scanner.nextLine();
    }

    public void showRentReturnResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }

    public User readLoginAndPassword() {
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }

    public static NewGUI getInstance() {
        return instance;
    }
}
