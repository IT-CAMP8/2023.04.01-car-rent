package pl.camp.it.car.rent;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean run = true;
        do {
            System.out.println("1. List cars");
            System.out.println("2. Rent car");
            System.out.println("3. Exit");

            Scanner wczytywacz = new Scanner(System.in);
            String choose = wczytywacz.nextLine();
            switch(choose) {
                case "1":
                    System.out.println("Listowanie aut !!");
                    break;
                case "2":
                    System.out.println("Wpisz tablice !!");
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        } while (run);
    }
}
