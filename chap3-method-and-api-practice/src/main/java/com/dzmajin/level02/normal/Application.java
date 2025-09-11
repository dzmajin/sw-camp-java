package com.dzmajin.level02.normal;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RandomMaker random = new RandomMaker();
        System.out.println("최솟값 : ");
        int min = sc.nextInt();
        System.out.println("최댓값 : ");
        int max = sc.nextInt();
        System.out.println(random.randomNumber(min,max));


    }
}
