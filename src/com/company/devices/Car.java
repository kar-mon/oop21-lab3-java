package com.company.devices;

import com.company.animals.Animal;
import com.company.animals.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;
    List<Human> owners = new Vector<Human>();

    public void registerOwner(Human owner){
        owners.add(owner);
    }

    public boolean wasOwner(Human allegedOwner){
        for (var owner:owners) {
            if (allegedOwner == owner){
                return true;
            }
        } return false;
    }

    private int getOwnerIndex(Human perhapsOwner){
            int index=owners.indexOf(perhapsOwner);
        return index;
    }

    public boolean ifHumanSoldToHuman(Human allegedSeller, Human allegedBuyer){
        if (getOwnerIndex(allegedSeller)==getOwnerIndex(allegedBuyer)-1){
            return true;
        }
        return false;
    }

    public int howManyTimesSold(){ //ile razy szpak był dziobany
        return owners.size()-1; //calculating how many times the car was sold after 1st owner, not taking into account that the 1st owner had to get the car somehow
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    //ArrayList<String> owners = new ArrayList<String>();

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {

        //if(seller.isCarOwned(this))
        if (seller == owners.get(owners.size() - 1))
        {
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
