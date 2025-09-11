package com.dzmajin.section01.conditional.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        practiceIfStatementHard practice =  new practiceIfStatementHard();
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 정수 : ");
        int a = sc.nextInt();
        System.out.println("두 번째 정수 : ");
        int b = sc.nextInt();
        System.out.println("연산 기호를 입력하세요 : ");
        char c = sc.next().charAt(0);

        practice.calculate(a, b, c);

    }

}
