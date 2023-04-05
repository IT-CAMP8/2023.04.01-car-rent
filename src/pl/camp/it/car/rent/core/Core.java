package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.BusRepository;
import pl.camp.it.car.rent.db.CarRepository;
import pl.camp.it.car.rent.gui.GUI;

public class Core {
    CarRepository baza = new CarRepository();
    BusRepository busesDB = new BusRepository();
    GUI gui = new GUI();
    public void start() {
        boolean run = true;
        do {
            String plate;
            boolean carSuccess, busSuccess;
            switch(gui.showMenu()) {
                case "1":
                    gui.listCars(baza.getCars());
                    gui.listBuses(busesDB.getBuses());
                    break;
                case "2":
                    plate = gui.readPlate();
                    carSuccess = baza.rentCar(plate);
                    busSuccess = busesDB.rentBus(plate);
                    gui.showRentReturnResult(
                            carSuccess || busSuccess);
                    break;
                case "3":
                    plate = gui.readPlate();
                    carSuccess = baza.returnCar(plate);
                    busSuccess = busesDB.returnBus(plate);
                    gui.showRentReturnResult(
                            carSuccess || busSuccess);
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
