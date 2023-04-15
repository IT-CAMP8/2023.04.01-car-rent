package pl.camp.it.car.rent.model;

public class Bus extends Vehicle {
    private int seats;
    private boolean ticketMachine;

    public Bus(String brand, String model, int year, double price, String plate, int seats, boolean ticketMachine) {
        super(brand, model, year, price, plate);
        this.seats = seats;
        this.ticketMachine = ticketMachine;
    }

    public Bus() {
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
