package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Vehicle;

public class VehicleRepository {
    private Vehicle[] vehicles = new Vehicle[8];

    public VehicleRepository() {
        this.vehicles[0] = new Car("BMW", "3", 2015,
                300.0, "KR11");
        this.vehicles[1] = new Car("Audi", "A5", 2016,
                350.0, "KR22");
        this.vehicles[2] = new Car("Kia", "Ceed", 2017,
                320.0, "KR33");
        this.vehicles[3] = new Car("Toyota", "Corolla",
                2018, 370.0, "KR44");
        this.vehicles[4] = new Car("Volvo", "V50", 2013,
                200.0, "KR55");
        this.vehicles[5] = new Bus("Star", "1000",
                2005, 600.0, "KR111", 52,
                true);
        this.vehicles[6] = new Bus("Jelcz", "S2000",
                1984, 900.0, "KR222", 30,
                false);
        this.vehicles[7] = new Bus("Volvo", "GTR",
                2006, 650.0, "KR333", 45,
                true);
    }

    public boolean rentVehicle(String plate) {
        for(Vehicle vehicle : this.vehicles) {
            if(!vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnVehicle(String plate) {
        for(Vehicle vehicle : this.vehicles) {
            if(vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(false);
                return true;
            }
        }
        return false;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
