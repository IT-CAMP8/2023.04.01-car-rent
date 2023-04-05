package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;

import java.util.Scanner;

public class GUI {
    Scanner scanner = new Scanner(System.in);

    /*GUI() {
        this.scanner = new Scanner(System.in);
    }*/
    public String showMenu() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");

        return scanner.nextLine();
    }

    public void listCars(Car[] cars) {
        for(Car car : cars) {
            if(!car.isRent()) {
                /*System.out.println(car.getBrand() + " " +
                        car.getModel() + " " +
                        car.getPrice() + " " +
                        car.getYear() + " " +
                        car.getPlate());*/
                System.out.println(new StringBuilder()
                        .append(car.getBrand())
                        .append(" ")
                        .append(car.getModel())
                        .append(" ")
                        .append(car.getPrice())
                        .append(" ")
                        .append(car.getYear())
                        .append(" ")
                        .append(car.getPlate())
                        .toString());
            }
        }
    }

    public void listBuses(Bus[] buses) {
        for(Bus bus : buses) {
            if(!bus.isRent()) {
                System.out.println(new StringBuilder()
                        .append(bus.getBrand())
                        .append(" ")
                        .append(bus.getModel())
                        .append(" ")
                        .append(bus.getPrice())
                        .append(" ")
                        .append(bus.getYear())
                        .append(" ")
                        .append(bus.getPlate())
                        .append(" ")
                        .append(bus.getSeats())
                        .append(" ")
                        .append(bus.isTicketMachine())
                        .toString());
            }
        }
    }

    public String readPlate() {
        System.out.println("Plate:");
        return scanner.nextLine();
    }

    public void showRentReturnResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }
}
