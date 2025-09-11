package com.dzmajin.section01.conditional.level02.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        practiceIfStatement practice = new practiceIfStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("당신의 체중(kg)를 입력하세요 : ");
        double kg = sc.nextDouble();
        System.out.println("당신의 신장(m)를 입력하세요 : ");
        double m = sc.nextDouble();

        practice.BMI(kg,m);
    }
}
