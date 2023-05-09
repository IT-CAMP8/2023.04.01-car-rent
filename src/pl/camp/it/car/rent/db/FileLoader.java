package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.core.Authenticator;
import pl.camp.it.car.rent.core.Core;
import pl.camp.it.car.rent.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FileLoader {

    private static final FileLoader instance = new FileLoader();

    private FileLoader() {}

    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);
            switch (objectData[0]) {
                case "Motorcycle":
                    VehicleRepository.getInstance().addVehicle(new Motorcycle(vars));
                    break;
                case "Bus":
                    VehicleRepository.getInstance().addVehicle(new Bus(vars));
                    break;
                case "Car":
                    VehicleRepository.getInstance().addVehicle(new Car(vars));
                    break;
                case "User":
                    UserRepository.getInstance().addUser(new User(vars));
                    break;
                default:
                    System.out.println("Unexpected type during DB loading !!");
                    break;
            }
        }
        reader.close();
    }

    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(VehicleRepository.getInstance().getVehicles());
        entries.addAll(UserRepository.getInstance().getUsers());
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("db.csv"));
        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFile = entry.toCSV();
            if (!firstTime) {
                writer.newLine();
            }
            firstTime = false;
            writer.write(lineInFile);
        }
        writer.close();
    }

    public static FileLoader getInstance() {
        return instance;
    }
}
