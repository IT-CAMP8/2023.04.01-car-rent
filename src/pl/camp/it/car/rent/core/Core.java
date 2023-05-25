package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.FileLoader;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.gui.IGUI;
import pl.camp.it.car.rent.gui.NewGUI;

import java.io.IOException;

public class Core {

    private static final Core instance = new Core();
    private final VehicleRepository database = VehicleRepository.getInstance();
    private final FileLoader fileLoader = FileLoader.getInstance();
    private final Authenticator authenticator = Authenticator.getInstance();
    private final IGUI gui;

    private Core() {}

    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }
        if(!authenticator.authenticate()) {
            return;
        }
        mainloop:
        while(true) {
            switch(gui.showMenu()) {
                case "1":
                    gui.listVehicles();
                    break;
                case "2":
                    gui.showRentReturnResult(database.rentVehicle(gui.readPlate()));
                    break;
                case "3":
                    gui.showRentReturnResult(database.returnVehicle(gui.readPlate()));
                    break;
                case "4":
                    try {
                        fileLoader.saveDataToFile();
                        break mainloop;
                    } catch (IOException e) {
                        System.out.println("Database Error !!");
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}
