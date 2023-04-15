package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.BusRepository;
import pl.camp.it.car.rent.db.CarRepository;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;

public class Core {
    //CarRepository baza = new CarRepository();
    //BusRepository busesDB = new BusRepository();
    VehicleRepository database = new VehicleRepository();
    GUI gui = new GUI();
    public void start() {
        boolean run = true;
        do {
            switch(gui.showMenu()) {
                case "1":
                    //gui.listCars(baza.getCars());
                    //gui.listBuses(busesDB.getBuses());
                    gui.listVehicles(database.getVehicles());
                    break;
                case "2":
                    gui.showRentReturnResult(database.rentVehicle(gui.readPlate()));
                    break;
                case "3":
                    gui.showRentReturnResult(database.returnVehicle(gui.readPlate()));
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        } while (run);
    }
}
