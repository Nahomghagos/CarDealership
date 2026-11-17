package com.pluralsight;

import java.math.BigDecimal;
import java.util.Scanner;



public class UserInterface {

Scanner myScanner = new Scanner(System.in);

public void userInterface(){

}
private void init () {

}
int choice = myScanner.nextInt();

public void display(){
    switch (choice) {
        case 1 -> getByPrice();
        case 2 -> getByMakeModel();
        case 3 -> getByYear();
        case 4 -> getByColor();
        case 5 -> getByMileage();
        case 6 -> getByType();
        case 7 -> getAllVehicles();
        case 8 ->addVehicle();
        default -> System.out.println("Invalid choice.");
    }
}
public void getByPrice() {
    System.out.println("please enter max price ");
    BigDecimal max = myScanner.nextBigDecimal();
    System.out.println("please enter min price");
    BigDecimal min = myScanner.nextBigDecimal();
}

public void getByMakeModel(){
    System.out.println("please enter the make of the vehicle ");
    String make = myScanner.nextLine();
    System.out.println("please enter the model of the vehicle ");
    String model = myScanner.nextLine();
    }
public void getByYear() {
    System.out.println("please enter the year ");
    int year = myScanner.nextInt();
}
public void getByColor() {
    System.out.println("please enter the color of the vehicle ");
    String color = myScanner.nextLine();
}
public void getByMileage() {
    System.out.println("please enter the mileage ");
    int mileage = myScanner.nextInt();
}
public void getByType() {
    System.out.println("please enter the vehicle type ");
    String vehicleType = myScanner.nextLine();
}
public void getAllVehicles() {

}
public void addVehicle() {
    Dealership dealership = new Dealership();

    System.out.print("please enter the vin ");
    int vin = myScanner.nextInt();

    System.out.print("please enter the year ");
    int year = myScanner.nextInt();

    System.out.print("please enter the make ");
    String make = myScanner.nextLine();

    System.out.print("please enter the model ");
    String model = myScanner.nextLine();

    System.out.print("please enter the type ");
    String vehicleType = myScanner.nextLine();

    System.out.print("please enter color ");
    String color = myScanner.nextLine();

    System.out.print("please enter the odometer reading ");
    int odometer = myScanner.nextInt();

    System.out.print("please enter the price  ");
    BigDecimal price = myScanner.nextBigDecimal();

    Vehicle vehicle = new Vehicle(
            vin, year, make, model, vehicleType,
            color, odometer, price
    );

    dealership.addVehicles(vehicle);

}





}
