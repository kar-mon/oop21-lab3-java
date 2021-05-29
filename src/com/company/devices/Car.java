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
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(seller.getCar() == this) {
            if (buyer.cash >= price) {
                buyer.cash -= price;
                seller.cash += price;
                buyer.setCar(this);
                seller.setCar(null);
                System.out.println("Car has been sold");
            } else {
                throw new Exception("Buyer does not have enough money");
            }
        } else {
            throw new Exception("Seller does not own the car");
        }
    }

    public void refuel() {
        currentFuel = MAX_FUEL;
    }
}
