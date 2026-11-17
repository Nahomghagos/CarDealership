package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;


public class DealershipFileManager {

    public static void main(String[] args) {


        String file ="inventory.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();

            String[] dealershipData = line.split("\\|");
            Dealership dealership = new Dealership(
                    dealershipData[0],
                    dealershipData[1],
                    dealershipData[2]
            );

            line = bufferedReader.readLine();

            while(line  != null) {
                String [] data = line.split("\\|");

                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(data[7]));

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

            }



        }
        catch (Exception Io) {
            System.out.println("file could not be read");
        }

    }

}
