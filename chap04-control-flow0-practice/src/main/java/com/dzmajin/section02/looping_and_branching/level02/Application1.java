package com.dzmajin.section02.looping_and_branching.level02;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        practiceLoop_and_Branch practice = new practiceLoop_and_Branch();
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요 : ");
        String s = sc.nextLine();
        practice.stringPrint(s);

        practice.alphabetPrint();
    }
}
