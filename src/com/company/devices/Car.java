package com.company.devices;

import com.company.animals.Human;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if(seller.car == this) {
            if (buyer.cash >= price) {
                buyer.cash -= price;
                seller.cash += price;
                buyer.car = this;
                seller.car = null;
                System.out.println("Car has been sold");
                return true;
            } else {
                System.out.println("Buyer does not have enough money");
            }
        } else {
            System.out.println("Seller does not own the car");
        }
        return false;
    }

    public void refuel() {
        currentFuel = MAX_FUEL;
    }
}
