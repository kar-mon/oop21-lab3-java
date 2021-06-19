package com.company.devices;

import com.company.animals.Animal;
import com.company.animals.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Date;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;

    public List<Transaction> transactionsList = new Vector<Transaction>();

    public void registerTransaction(Human seller, Human buyer,double price, Date transactionDate){
        transactionsList.add(new Transaction(seller,buyer,price,transactionDate));
    }

    public boolean wasOwner(Human allegedOwner){
        for (var transaction:transactionsList) {
            if (allegedOwner == transaction.deviceBuyer){
                return true;
            }
        } return false;
    }

     public boolean ifHumanSoldToHuman(Human allegedSeller, Human allegedBuyer){
         for (var transaction:transactionsList) {
        if (transaction.deviceSeller == allegedSeller && transaction.deviceBuyer == allegedBuyer) {
            return true;
        }}
        return false;
    }

    public int howManyTimesSold(){
        return transactionsList.size()-1; //calculating how many times the car was sold after 1st owner, not taking into account that the 1st owner had to get the car somehow
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        var lastTransaction = transactionsList.get(transactionsList.size() - 1);
        if (seller == lastTransaction.deviceBuyer)
        {
            if (buyer.cash >= price) {
                if(buyer.isSpot()){
                buyer.cash -= price;
                seller.cash += price;
                buyer.setCar(this);
                seller.removeCar(this);
                registerTransaction(seller, buyer, price,new Date());
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
