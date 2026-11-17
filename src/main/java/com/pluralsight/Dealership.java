package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }



    public List<Vehicle> getVehiclesByPrice (BigDecimal min, BigDecimal max){
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMillage(int min, int max){
        return null;
    }
    public List<Vehicle> getVehiclesByType (String type) {
        return null;
    }
    public List<Vehicle> getVehiclesColor (String color) {
        return null;
    }
    public List<Vehicle> getAllVehicles () {
        return inventory;
    }
    public List<Vehicle> getVehiclesVin (int vin ) {
        return null;
    }
    public List<Vehicle> addVehicles (Vehicle vehicle){
        inventory.add(vehicle);


    }









}
