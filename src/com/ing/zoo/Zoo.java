package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.types.Animal;
import com.ing.zoo.types.Carnivore;
import com.ing.zoo.types.Herbivore;
import com.ing.zoo.types.Omnivore;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Zoo {
    public static void main(String[] args)
    {
        //Array of command Strings
        String[] commands = new String[5];
        commands[0] = "hello";
        commands[1] = "give leaves";
        commands[2] = "give meat";
        commands[3] = "perform trick";
        commands[4] = "exit";

        //ArrayList of Animals
        ArrayList<Animal> animals = new ArrayList<>();
        Lion henk = new Lion();
        henk.name = "henk";
        animals.add(henk);
        Hippo elsa = new Hippo();
        elsa.name = "elsa";
        animals.add(elsa);
        Pig dora = new Pig();
        dora.name = "dora";
        animals.add(dora);
        Tiger wally = new Tiger();
        wally.name = "wally";
        animals.add(wally);
        Zebra marty = new Zebra();
        marty.name = "marty";
        animals.add(marty);
        Cat maggie = new Cat();
        maggie.name = "maggie";
        animals.add(maggie);
        Giraffe john = new Giraffe();
        john.name = "john";
        animals.add(john);

        AtomicBoolean running = new AtomicBoolean(true);

        do {
        //Boolean to check if a known command was entered
        AtomicBoolean correctCommand = new AtomicBoolean(false);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your command: ");

        String input = scanner.nextLine();

        //Loops through each animal in the animal list
        animals.forEach(animal -> {

            //Command 0 + Name
            if (input.equals(commands[0] + " " + animal.name)) {
                correctCommand.set(true);
                animal.sayHello();
            }

            //Command 0 no name
            else if (input.equals(commands[0])) {
                correctCommand.set(true);
                animal.sayHello();
            }

            //Command 1
            else if (input.equals(commands[1])) {
                correctCommand.set(true);
                if (animal instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) animal;
                    herbivore.eatLeaves();
                } else if (animal instanceof Omnivore) {
                    Omnivore omnivore = (Omnivore) animal;
                    omnivore.eatLeaves();
                }
            }

            //Command 2
            else if (input.equals(commands[2])) {
                correctCommand.set(true);
                if (animal instanceof Carnivore) {
                    Carnivore carnivore = (Carnivore) animal;
                    carnivore.eatMeat();
                } else if (animal instanceof Omnivore) {
                    Omnivore omnivore = (Omnivore) animal;
                    omnivore.eatMeat();
                }
            }

            //Command 3
            else if (input.equals(commands[3])) {
                correctCommand.set(true);
                animal.performTrick();
            }

            //Command 4
            else if (input.equals(commands[4])){
                correctCommand.set(true);
                running.set(false);
            }
        });

        //Unknown command
        if (!correctCommand.get()) {
            System.out.println("Unknown command: " + input);
        }

    }while(running.get());
    }
}
