package com.company.animals;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    List<Animal> pets;
    public Phone phone;
    public Car car;
    public Double cash;
    public String[] fingerNames;

    public final int FINGER_COUNT = 10;
    public final static String HUMAN_SPECIE = "homo sapiens";

    private Double salary;

    public Human(Double salary) {
        super(HUMAN_SPECIE);
        this.setSalary(salary);
        fingerNames = new String[FINGER_COUNT];
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
