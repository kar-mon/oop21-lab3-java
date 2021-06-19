package com.company.animals;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    List<Animal> pets;
    public Phone phone;
    private Car[] garage;
    public Double cash = 0.0;



    public Car getCar(int parkingSpotNo) {
        return garage[parkingSpotNo];
    }

    public void setCar(Car vehicle, int parkingSpotNo) {
        garage[parkingSpotNo] = vehicle;
    if (vehicle != null){
        vehicle.registerOwner(this);
    }    }

    public void setCar(Car vehicle) {
        for (int i =0; i<garage.length; i++){
      if (garage[i] == null) {setCar(vehicle, i); break;} ;
    }}

    public void removeCar(Car vehicle){
        for (int i = 0; i<garage.length; i++){
            if (garage[i] == vehicle) setCar(null, i);
        }
    }

    public boolean isCarOwned (Car auto){
        for (var a:garage
             ) {
            if (a == auto) return true;
               }
        return false;
    }

    public boolean isSpot(){
        for (var n : garage) {
            if (n == null) return true;
        }
        return false;
    }

    public double garageCarsValue(){
        double carsValue = 0.0;
        for (Car vehicle: garage) {
            if (vehicle != null) {
            carsValue += vehicle.getValue(); }}
        return carsValue;
    };

    public List<Car> CarsSortedByYear() {
        List<Car> SortedCarsList = new Vector<Car>();
        for (var c :garage) {
            if (c != null){
          SortedCarsList.add(c);
            }
        };
        SortedCarsList.sort((Car c1, Car c2)-> c1.getYearOfProduction()- c2.getYearOfProduction());
        return SortedCarsList;
    };

    public String[] fingerNames;

    public final int FINGER_COUNT = 10;
    public final static String HUMAN_SPECIE = "homo sapiens";

    private Double salary;

    public Human(Double salary,int garageSize) {
        super(HUMAN_SPECIE);
        this.setSalary(salary);
        fingerNames = new String[FINGER_COUNT];
        garage = new Car[garageSize];
        this.cash = salary;
    }

    public Human(Double salary){
        this(salary, 0);
    }


    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        } else {
            System.out.println("NOBODY WILL PAY FOR WORKING");
            this.salary = 0.0;
        }
    }

    public void addPet(Animal pet) {
        if(pets == null) {
            pets = new ArrayList<Animal>();
        }
        pets.add(pet);
    }

    public List<Animal> getPets() {
        return pets;
    }

}
