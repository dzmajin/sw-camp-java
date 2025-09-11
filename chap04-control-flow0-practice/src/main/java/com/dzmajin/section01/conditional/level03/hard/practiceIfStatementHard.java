package com.dzmajin.section01.conditional.level03.hard;

public class practiceIfStatementHard {
    public void calculate(int a, int b,char c){
        /* 두 개의 정수를 입력 받아 변수에 저장하고,
         * 연산기호(+, -, *, /, %)를 입력 받아 해당 연산의 수행 결과를 출력하세요.
         * 단, 준비된 연산기호 외의 문자를 입력하는 경우 "입력하신 연산은 없습니다. 프로그램을 종료합니다." 출력 후 프로그램 종료
         *
         * -- 입력 예시 --
         * 첫 번째 정수 : 4
         * 두 번째 정수 : 3
         * 연산 기호를 입력하세요 : +
         *
         * -- 출력 예시 --
         * 4 + 3 = 7
         */
        switch (c){
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a*b);
                break;
            case '/':
                System.out.println(a/b);
                break;
            case '%':
                System.out.println(a%b);
                break;
            default:
                System.out.println("입력하신 연산은 없습니다. 프로그램을 종료합니다.");
        }
    }

    /* 과일 이름("사과", "바나나", "복숭아", "키위") 중 한 가지를 문자열로 입력하면
     * 해당하는 가격에 맞게 상품명과 가격이 출력되게 하세요.
     * 단, 목록에 없는 과일을 입력 시 "준비된 상품이 없습니다." 출력 후 프로그램 종료
     *
     * -- 상품 가격 --
     * 사과 :  1000원
     * 바나나 : 3000원
     * 복숭아 : 2000원
     * 키위 : 5000원
     *
     * -- 입력 예시 --
     * 과일 이름을 입력하세요 : 바나나
     *
     * -- 출력 예시 --
     * 바나나의 가격은 3000원 입니다.
     * */

    public void fruitsStore(String s){

    }
}
