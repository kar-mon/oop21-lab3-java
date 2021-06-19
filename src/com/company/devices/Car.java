package com.company.devices;

import com.company.animals.Human;

import java.util.ArrayList;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    ArrayList<String> owners = new ArrayList<String>();

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {

        if(seller.isCarOwned(this)) {
            if (buyer.cash >= price) {
                if(buyer.isSpot()){
                buyer.cash -= price;
                seller.cash += price;
                buyer.setCar(this);
                seller.removeCar(this);
                System.out.println("Car has been sold");
            }
            else {
                throw new Exception("The buyer does not have parking spot available");
            }}
            else {
                throw new Exception("The buyer does not have enough money");
            }


        } else {
            throw new Exception("The seller does not own the car");
        }
    }

    public void refuel() {
        currentFuel = MAX_FUEL;
    }
}
