package com.company;

import com.company.animals.*;
import com.company.devices.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Human me = new Human(1000.0,5);
        me.firstName = "Jan";
        me.lastName = "Kowalski";

        Human buyer = new Human(2000.0, 3);
        buyer.firstName = "Grzegorz";
        buyer.lastName = "Brzeczyszczykiewicz";

        Human seller = new Human(7500.0,3);
        seller.firstName = "Froddo";
        seller.lastName = "Baggins";

        Human somebody = new Human(3500.5,2);
        somebody.firstName = "Grazyna";
        somebody.lastName = "Karczoch";

        Human someone = new Human(8500.77,1);
        someone.firstName = "Andrzej";
        someone.lastName = "Karczoch";

        Human humanA = new Human(1500.0,2); humanA.firstName ="A"; humanA.lastName = "A";
        Human humanB = new Human(2500.1,2); humanB.firstName ="B"; humanB.lastName = "B";
        Human humanC = new Human(3500.5,2); humanC.firstName ="C"; humanC.lastName = "C";
        Human humanD = new Human(4500.0,2); humanD.firstName ="D"; humanD.lastName = "D";


        Animal dog = new Animal("dog");
        dog.name = "Szarik";
        Animal cat = new Animal("cat");
        cat.name = "Puszek";
        Animal dog2 = new Animal("dog");
        dog2.name = "Fafik";
        Animal cat2 = new Animal("cat");
        cat2.name = "Cat";

        me.addPet(dog);
        me.addPet(cat);
        List<Animal> pets = me.getPets();
        for (Animal pet: pets) {
            System.out.println(pet.name);
        }

        buyer.addPet(dog2);
        seller.addPet(cat2);

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

        List<String> sortedFingerNames = Arrays.stream(me.fingerNames).sorted().toList();

        for (String fingerName: sortedFingerNames) {
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

        Phone nokia = new Phone ("nokia","3310", 1.5,null);


        onePlus.turnOn();

        Car fiat = new Car();
        fiat.engineSize = 1.9;
        fiat.fuelType = "Diesel";
        fiat.setProducer("Fiat");
        fiat.setModel("Bravo");
        fiat.setYearOfProduction(1995);
        fiat.setValue(50.0);

        Car volvo = new Car();
        volvo.engineSize = 3.5;
        volvo.fuelType = "Diesel";
        volvo.setProducer("Volvo");
        volvo.setModel("XC70");
        volvo.setYearOfProduction(2010);
        volvo.setValue(35000.0);

        Car fiat2 = new Car();
        fiat2.engineSize = 1.0;
        fiat2.fuelType = "LPG";
        fiat2.setProducer("fiat");
        fiat2.setModel("punto");
        fiat2.setYearOfProduction(2000);
        fiat2.setValue(500.0);

        Car mercedes = new Car();
        mercedes.engineSize = 2.0;
        mercedes.fuelType = "Diesel";
        mercedes.setProducer("mercedes");
        mercedes.setModel("G class");
        mercedes.setYearOfProduction(1987);
        mercedes.setValue(50000.0);

        Car golf = new Car();
        golf.engineSize = 1.5;
        golf.fuelType = "Diesel";
        golf.setProducer("Volkswagen");
        golf.setModel("Golf");
        golf.setYearOfProduction(2021);
        golf.setValue(35000.0);

        Car opel = new Car();
        opel.engineSize = 1.9;
        opel.fuelType = "Petrol";
        opel.setProducer("opel");
        opel.setModel("corsa");
        opel.setYearOfProduction(2019);
        opel.setValue(15000.0);


        me.setCar(fiat, 0);
        me.setCar(volvo, 1);

        seller.setCar(fiat2,0);
        seller.setCar(golf,1);
        somebody.setCar(mercedes,1);

        System.out.println("sprzedam opla");

        buyer.setCar(opel,0);

        try{ fiat2.sell(seller,buyer,500.0);}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        try{ mercedes.sell(somebody,someone,30000.0);}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        try{ fiat.sell(me,buyer,50.0);}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println(me.garageCarsValue());
        System.out.println(me.CarsSortedByYear());

        System.out.println(seller.garageCarsValue());
        System.out.println(seller.CarsSortedByYear());

        System.out.println(buyer.garageCarsValue());
        System.out.println(buyer.CarsSortedByYear());

        System.out.println(somebody.garageCarsValue());
        System.out.println(somebody.CarsSortedByYear());

        System.out.println(someone.garageCarsValue());
        System.out.println(someone.CarsSortedByYear());


        System.out.println(iPhone6.getModel());
        System.out.println(iPhone6.getProducer());
        System.out.println(iPhone6.os);
        System.out.println(iPhone6.screenSize);

        fiat.turnOn();
        iPhone6.turnOn();

        Car volga = new Car();
        volga.engineSize = 2.5;
        volga.fuelType = "petrol";
        volga.setProducer("GAZ");
        volga.setModel("M-21 Volga");
        volga.setYearOfProduction(1956);
        volga.setValue(1000.0);

        humanA.setCar(volga,0);
        try{ volga.sell(humanA,humanB,1000.0);}
        catch(Exception e){System.out.println(e.getMessage());}

        try{ volga.sell(humanB,humanC,900.0);}
        catch(Exception e){System.out.println(e.getMessage());}

        try{ volga.sell(humanC,humanA,800.0);}
        catch(Exception e){System.out.println(e.getMessage());}

        try{ volga.sell(humanA,humanD,700.0);}
        catch(Exception e){System.out.println(e.getMessage());}

        System.out.println("The car was sold " + volga.howManyTimesSold() +" times");

        System.out.println(volga.ifHumanSoldToHuman(humanC,humanB));

        System.out.println("Volga's history is: " + volga.transactionsList);

    }
}
