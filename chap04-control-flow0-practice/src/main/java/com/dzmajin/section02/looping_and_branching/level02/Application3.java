package com.dzmajin.section02.looping_and_branching.level02;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        practiceLoop_and_Branch practice = new practiceLoop_and_Branch();
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요. : ");
        int num = sc.nextInt();

        practice.watermelonPrint(num);
    }
}
