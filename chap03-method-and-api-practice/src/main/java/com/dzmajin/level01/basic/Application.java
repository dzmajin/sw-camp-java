package com.dzmajin.level01.basic;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application(); //객체 생성
        Calculator calc = new Calculator();  //객체 생성

        //메소드 호출 확인용 메소드 호출
        calc.checkMethod();

        //함수를 호출하여 1~10까지의 합을 리턴 받아 출력
        System.out.println("1부터 10까지의 합: "+calc.sum1to10());

        //10, 20 두 개의 정수를 매개변수로 하여 큰 값 출력하는 메소드 호출
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번 째 숫자: ");
        int a = sc.nextInt();
        System.out.println("두번 째 숫자: ");
        int b = sc.nextInt();
        calc.checkMaxNumber(a,b);

        //10, 20 두 개의 정수를 매개변수로 하여 두 수를 더하는 메소드 호출 후 리턴값 출력
        System.out.println("첫번 째 숫자: ");
        int num1 = sc.nextInt();
        System.out.println("두번 째 숫자: ");
        int num2 = sc.nextInt();
        System.out.println(num1+"과"+num2+"의 합은: "+calc.sumTwoNumber(num1,num2));

        //10, 5 두 개의 정수를 매개변수로 하여 두 수의 차를 구하는 메소드 호출 후 리턴값 출력
        System.out.println("첫번 째 숫자: ");
        int x = sc.nextInt();
        System.out.println("두번 째 숫자: ");
        int y = sc.nextInt();
        System.out.println(x+"과"+y+"의 차는: "+calc.minusTwoNumber(x,y));

    }
}
