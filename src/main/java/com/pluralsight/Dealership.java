package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public List<Vehicle> getVehicleByPrice (BigDecimal min, BigDecimal max){
        return null;
    }
    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }
    public List<Vehicle> getVehicleByYear(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehicleByMillage(int min, int max){
        return null;
    }
    public List<Vehicle> getVehicleByType (String type) {
        return null;
    }
    public List<Vehicle> getVehicleColor (String color) {
        return null;
    }
    public List<Vehicle> getAllVehicles () {
        return null;
    }








}
