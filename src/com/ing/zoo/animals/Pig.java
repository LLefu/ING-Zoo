package com.ing.zoo.animals;
import com.ing.zoo.types.Omnivore;
import java.util.Random;

public class Pig extends Omnivore {
    public String trick;

    public Pig()
    {
        helloText = "splash";
        eatText = "munch munch oink";

    }

    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            trick = "rolls in the mud";
        }
        else
        {
            trick = "runs in circles";
        }
        System.out.println(trick);
    }

}
