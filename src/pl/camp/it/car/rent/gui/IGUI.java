package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

public interface IGUI {
    public String showMenu();

    public void listVehicles();

    public String readPlate();

    public void showRentReturnResult(boolean result);

    public User readLoginAndPassword();
}
