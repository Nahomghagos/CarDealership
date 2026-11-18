package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {

    public Dealership getDealership() {
        String file = "inventory.csv";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();

            String[] dealershipData = line.split("\\|");

            Dealership dealership = new Dealership(
                    dealershipData[0],
                    dealershipData[1],
                    dealershipData[2]
            );

            line = bufferedReader.readLine();

            while (line != null) {
                String[] data = line.split("\\|");

                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                BigDecimal price = new BigDecimal(data[7]);

                Vehicle vehicle = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price
                );

                dealership.addVehicles(vehicle);

                line = bufferedReader.readLine();
            }

            return dealership;

        } catch (Exception e) {
            System.out.println("file could not be read.");
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("inventory.csv"))) {

            writer.write(
                         dealership.getName() + "|" +
                                 dealership.getAddress() + "|" +
                                 dealership.getPhone()
            );
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("could not save dealership.");
        }
    }
}
