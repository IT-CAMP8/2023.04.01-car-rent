package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.UserRepository;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

public class Core {
    VehicleRepository database = new VehicleRepository();
    GUI gui = new GUI();
    Authenticator authenticator = new Authenticator();
    public void start() {
        if(!authenticator.authenticate()) {
            return;
        }
        mainloop:
        while(true) {
            switch(gui.showMenu()) {
                case "1":
                    gui.listVehicles(database.getVehicles());
                    break;
                case "2":
                    gui.showRentReturnResult(database.rentVehicle(gui.readPlate()));
                    break;
                case "3":
                    gui.showRentReturnResult(database.returnVehicle(gui.readPlate()));
                    break;
                case "4":
                    break mainloop;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
