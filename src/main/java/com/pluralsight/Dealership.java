package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> price = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0
                    && vehicle.getPrice().compareTo(max) <= 0) {
                price.add(vehicle);
            }
        }
        return price;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> makeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)
                    && vehicle.getModel().equalsIgnoreCase(model)) {
                makeModel.add(vehicle);
            }
        }
        return makeModel;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> year = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                year.add(vehicle);
            }
        }
        return year;
    }
    public List<Vehicle> getVehiclesByMillage(int min, int max) {
        List<Vehicle> millage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min
                    && vehicle.getOdometer() <= max) {
                millage.add(vehicle);
            }
        }
        return millage;
    }
    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> vehicleType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                vehicleType.add(vehicle);
            }
        }
        return vehicleType;
    }
    public List<Vehicle> getVehiclesColor(String color) {
        List<Vehicle> vehicleColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehicleColor.add(vehicle);
            }
        }
        return vehicleColor;
    }
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
    public void addVehicles(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }




}
