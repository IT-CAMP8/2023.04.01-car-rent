package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.Car;

//DO KOSZA
public class CarRepository {
    private Car[] cars = new Car[5];

    public CarRepository() {
        this.cars[0] = new Car("BMW", "3", 2015,
                300.0, "KR11");
        this.cars[1] = new Car("Audi", "A5", 2016,
                350.0, "KR22");
        this.cars[2] = new Car("Kia", "Ceed", 2017,
                320.0, "KR33");
        this.cars[3] = new Car("Toyota", "Corolla",
                2018, 370.0, "KR44");
        this.cars[4] = new Car("Volvo", "V50", 2013,
                200.0, "KR55");
    }

    public boolean rentCar(String plate) {
        for(Car car : this.cars) {
            if(!car.isRent() && car.getPlate().equals(plate)) {
                car.setRent(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnCar(String plate) {
        for(Car car : this.cars) {
            if(car.isRent() && car.getPlate().equals(plate)) {
                car.setRent(false);
                return true;
            }
        }
        return false;
    }

    public Car[] getCars() {
        return cars;
    }
}
