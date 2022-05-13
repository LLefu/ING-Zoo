package com.ing.zoo.animals;
import com.ing.zoo.types.Carnivore;
import java.util.Random;

public class Cat extends Carnivore {
    public String trick;

    public Cat(){
        helloText = "Meow";
        eatText = "chomp, chomp";
    }

    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            trick = "rolls on back";
        }
        else
        {
            trick = "jumps on table";
        }
        System.out.println(trick);
    }

}
