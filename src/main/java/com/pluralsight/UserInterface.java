package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner myScanner = new Scanner(System.in);
    private Dealership dealership;

    public void userInterface() {
        display();
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        init();
        System.out.println("1 - Search by price ");
        System.out.println("2 - Search by make and model ");
        System.out.println("3 - Search by year ");
        System.out.println("4 - Search by color ");
        System.out.println("5 - Search by mileage ");
        System.out.println("6 - Search by type ");
        System.out.println("7 - List all vehicles ");
        System.out.println("8 - Add a vehicle ");
        System.out.println("9 - remove a vehicle");

        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice) {
            case 1 -> getByPrice();
            case 2 -> getByMakeModel();
            case 3 -> getByYear();
            case 4 -> getByColor();
            case 5 -> getByMillage();
            case 6 -> getByType();
            case 7 -> getAllVehicles();
            case 8 -> addVehicle();
            case 9 ->removeVehicle();
            default -> System.out.println("Invalid choice.");
        }

    }

    public void getByPrice() {
        System.out.println("please enter min price");
        BigDecimal min = new BigDecimal(myScanner.nextLine());
        System.out.println("please enter max price ");
        BigDecimal max = new BigDecimal(myScanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void getByMakeModel() {
        System.out.println("please enter the make of the vehicle ");
        String make = myScanner.nextLine();
        System.out.println("please enter the model of the vehicle ");
        String model = myScanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void getByYear() {
        System.out.println("please enter the minimum year ");
        int minYear = Integer.parseInt(myScanner.nextLine());
        System.out.print("please enter the maximum year ");
        int maxYear = Integer.parseInt(myScanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    public void getByColor() {
        System.out.println("please enter the color of the vehicle ");
        String color = myScanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesColor(color);
        displayVehicles(vehicles);
    }

    public void getByMillage() {
        System.out.println("please enter the minimum mileage ");
        int minimumMillage = Integer.parseInt(myScanner.nextLine());
        System.out.println("please enter maximum mileage ");
        int maximumMillage = Integer.parseInt(myScanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByMillage(minimumMillage, maximumMillage);
        displayVehicles(vehicles);
    }

    public void getByType() {
        System.out.println("please enter the vehicle type ");
        String vehicleType = myScanner.nextLine();


        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void getAllVehicles() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void addVehicle() {

        System.out.print("please enter the vin ");
        int vin = Integer.parseInt(myScanner.nextLine());

        System.out.print("please enter the year ");
        int year = Integer.parseInt(myScanner.nextLine());

        System.out.print("please enter the make ");
        String make = myScanner.nextLine();

        System.out.print("please enter the model ");
        String model = myScanner.nextLine();

        System.out.print("please enter the type ");
        String vehicleType = myScanner.nextLine();

        System.out.print("please enter color ");
        String color = myScanner.nextLine();

        System.out.print("please enter the odometer reading ");
        int odometer = Integer.parseInt(myScanner.nextLine());

        System.out.print("please enter the price  ");
        BigDecimal price = new BigDecimal(myScanner.nextLine());

        Vehicle vehicle = new Vehicle(
                vin, year, make, model, vehicleType,
                color, odometer, price
        );

        dealership.addVehicles(vehicle);

    }
    private void removeVehicle() {
        System.out.print("please enter the vin of the vehicle you want to remove: ");
        int vin = Integer.parseInt(myScanner.nextLine());
        Vehicle removeVehicle = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin && removeVehicle == null) {
                removeVehicle = vehicle;
            }
        }
        if (removeVehicle != null) {
            dealership.removeVehicle(removeVehicle);
            DealershipFileManager fileManager = new DealershipFileManager();

            fileManager.saveDealership(dealership);

            System.out.println("vehicle removed.");
        } else {
            System.out.println("No vehicle found with that vin.");
        }
    }



}
