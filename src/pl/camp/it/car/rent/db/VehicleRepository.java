package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    private static final VehicleRepository instance = new VehicleRepository();
    private VehicleRepository() {}
    /*public VehicleRepository() {
        this.vehicles.put("KR11", new Car("BMW", "3", 2015,
                300.0, "KR11"));
        this.vehicles.put("KR22", new Car("Audi", "A5", 2016,
                350.0, "KR22"));
        this.vehicles.put("KR33", new Car("Kia", "Ceed", 2017,
                320.0, "KR33"));
        this.vehicles.put("KR44", new Car("Toyota", "Corolla",
                2018, 370.0, "KR44"));
        this.vehicles.put("KR55", new Car("Volvo", "V50", 2013,
                200.0, "KR55"));
        this.vehicles.put("KR111", new Bus("Star", "1000",
                2005, 600.0, "KR111", 52,
                true));
        this.vehicles.put("KR222", new Bus("Jelcz", "S2000",
                1984, 900.0, "KR222", 30,
                false));
        this.vehicles.put("KR333", new Bus("Volvo", "GTR",
                2006, 650.0, "KR333", 45,
                true));
        this.vehicles.put("KR1111", new Motorcycle("Suzuki", "G100",
                2010, 200.00, "KR1111"));
        this.vehicles.put("KR2222", new Motorcycle("BMW", "C100",
                2011, 250.00, "KR2222"));
    }*/

    public boolean rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
        /*for(Vehicle vehicle : this.vehicles) {
            if(!vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(true);
                return true;
            }
        }
        return false;*/
    }

    public boolean returnVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
        /*for(Vehicle vehicle : this.vehicles) {
            if(vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(false);
                return true;
            }
        }
        return false;*/
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getPlate(), vehicle);
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles.values();
    }

    public static VehicleRepository getInstance() {
        return instance;
    }
}
