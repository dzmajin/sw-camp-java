package com.dzmajin.section02.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        practice_Loop_and_Branch_hard hard =  new practice_Loop_and_Branch_hard();
        Scanner sc = new Scanner(System.in);

        System.out.println("2보다 큰 정수를 입력하세요 : ");
        int num = sc.nextInt();
        hard.isPrimeNumber(num);

    }
}
