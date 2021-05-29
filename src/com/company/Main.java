package com.company;

import com.company.animals.*;
import com.company.devices.*;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Human me = new Human(1000.0);
        me.firstName = "Jan";
        me.lastName = "Kowalski";

        Animal dog = new Animal("dog");
        dog.name = "Szarik";
        Animal cat = new Animal("cat");
        cat.name = "Puszek";

        me.addPet(dog);
        me.addPet(cat);
        List<Animal> pets = me.getPets();
        for (Animal pet: pets) {
            System.out.println(pet.name);
        }

        for(int i=0;i<pets.size();i++) {
            System.out.println(String.format("Pet number %d is named %s and weights %.2f", i, pets.get(i).name, pets.get(i).getWeight()));
        }

        List<Animal> sortedAnimalsFirstApproach = pets.stream().sorted(Comparator.comparing(Animal::getWeight)).toList();
        for (Animal pet: sortedAnimalsFirstApproach) {
            System.out.println(String.format("Pet named %s weights %.2f", pet.name, pet.getWeight()));
        }
        List<Animal> sortedAnimalsSecondApproach = pets.stream().sorted(new AnimalWeightComparator()).toList();
        for (Animal pet: sortedAnimalsSecondApproach) {
            System.out.println(String.format("Pet named %s weights %.2f", pet.name, pet.getWeight()));
        }

        me.fingerNames[0] = "Left pinkie";
        me.fingerNames[1] = "Left ring";
        me.fingerNames[2] = "Left middle";
        me.fingerNames[3] = "Left index";
        me.fingerNames[4] = "Left thumb";

        me.fingerNames[5] = "Right thumb";
        me.fingerNames[6] = "Right index";
        me.fingerNames[7] = "Right middle";
        me.fingerNames[8] = "Right ring";
        me.fingerNames[9] = "Right pinkie";

        System.out.println(String.format("I have %d fingers", me.fingerNames.length));

        for (String fingerName: me.fingerNames) {
            System.out.println(fingerName);
        }


        Phone onePlus = new Phone("onePlus",
                "8Pro",
                2.3,
                "Android");

        Phone iPhone6 = new Phone("Apple", "6s", 5.0, "iOS");

        System.out.println("phone: " + onePlus);
        System.out.println("phone: " + iPhone6);
        System.out.println("human: " + me);


        onePlus.turnOn();

        Car fiat = new Car();
        fiat.engineSize = 1.9;
        fiat.fuelType = "Diesel";
        fiat.producer = "Fiat";
        fiat.model = "Bravo";

        System.out.println(iPhone6.os);
        System.out.println(iPhone6.screenSize);
        System.out.println(iPhone6.model);
        System.out.println(iPhone6.producer);

        fiat.turnOn();
        iPhone6.turnOn();
    }
}
