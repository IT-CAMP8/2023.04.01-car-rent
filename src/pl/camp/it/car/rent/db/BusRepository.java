package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.Bus;

//DO KOSZA
public class BusRepository {
    private Bus[] buses = new Bus[3];

    public BusRepository() {
        this.buses[0] = new Bus("Star", "1000",
                2005, 600.0, "KR111", 52,
                true);
        this.buses[1] = new Bus("Jelcz", "S2000",
                1984, 900.0, "KR222", 30,
                false);
        this.buses[2] = new Bus("Volvo", "GTR",
                2006, 650.0, "KR333", 45,
                true);
    }

    public boolean rentBus(String plate) {
        for(Bus bus : this.buses) {
            if(!bus.isRent() && bus.getPlate().equals(plate)) {
                bus.setRent(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnBus(String plate) {
        for(Bus bus : this.buses) {
            if(bus.isRent() && bus.getPlate().equals(plate)) {
                bus.setRent(false);
                return true;
            }
        }
        return false;
    }

    public Bus[] getBuses() {
        return buses;
    }
}
