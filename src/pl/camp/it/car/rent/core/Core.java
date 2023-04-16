package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;

public class Core {
    private static final VehicleRepository database = new VehicleRepository();
    public static void start() {
        if(!Authenticator.authenticate()) {
            return;
        }
        mainloop:
        while(true) {
            switch(GUI.showMenu()) {
                case "1":
                    GUI.listVehicles(database.getVehicles());
                    break;
                case "2":
                    GUI.showRentReturnResult(database.rentVehicle(GUI.readPlate()));
                    break;
                case "3":
                    GUI.showRentReturnResult(database.returnVehicle(GUI.readPlate()));
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
