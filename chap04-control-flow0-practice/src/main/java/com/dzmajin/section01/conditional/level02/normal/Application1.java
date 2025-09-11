package com.dzmajin.section01.conditional.level02.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        practiceIfStatement practice = new practiceIfStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("1~10사이 정수를 입력하세요 : ");
        int num = sc.nextInt();
        practice.OddEvenChecker(num);

    }
}
