package pl.camp.it.car.rent.model;

public class Bus {
    private String brand;
    private String model;
    private int year;
    private double price;
    private String plate;
    private boolean rent = false;
    private int seats;
    private boolean ticketMachine;

    public Bus(String brand, String model, int year, double price, String plate, int seats, boolean ticketMachine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.plate = plate;
        this.seats = seats;
        this.ticketMachine = ticketMachine;
    }

    public Bus() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isTicketMachine() {
        return ticketMachine;
    }

    public void setTicketMachine(boolean ticketMachine) {
        this.ticketMachine = ticketMachine;
    }
}
