package com.dzmajin.level02.normal;

import java.util.Random;

public class RandomMaker {

    public int  randomNumber(int min,int max){
        Random random = new Random();
        return  (int)(Math.random()*(max-min+1)+min);
    }

}
