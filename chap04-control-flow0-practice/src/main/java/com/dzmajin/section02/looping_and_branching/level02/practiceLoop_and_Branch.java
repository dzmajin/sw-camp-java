package com.dzmajin.section02.looping_and_branching.level02;

import javax.lang.model.element.NestingKind;

public class practiceLoop_and_Branch {
    /* 문자열을 입력 받아서 문자열의 각 인덱스별로 한 글자씩 출력하세요
     *
     * 참고) 문자열의 길이는 String 클래스의 length() 메소드를 이용할 수 있습니다.
     *
     * -- 입력 예시 --
     * 문자열을 입력하세요 : apple
     *
     * -- 출력 예시 --
     * 0 : a
     * 1 : p
     * 2 : p
     * 3 : l
     * 4 : e
     * */
    public void stringPrint(String s){
        for(int j=0;j<s.length();j++){
            System.out.println(j+":"+s.charAt(j));
        }
    }

    /* 반복문을 이용하여 알파벳 소문자 'a'부터 'z'까지를 개행 없이 차례로 출력하세요
     *
     * -- 출력 예시 --
     * abcdefghijklmnopqrstuvwxyz
     * */

    public void alphabetPrint(){
        for(int i = 97; i <= 122; i++){
            System.out.print((char)i);
        }
    }

    /* 정수를 입력받아 1부터 입력받은 정수까지
     * 홀수이면 "수", 짝수이면 "박"이 정수만큼 누적되어 출력되게 작성하시오.
     *
     * -- 입력 예시 --
     * 정수를 입력하세요 : 5
     *
     * -- 출력 예시 --
     * 수박수박수
     * */

    public void watermelonPrint(int num){
        char[] s = new char[num]; //String은 불변 값이라 인덱스에 값 넣는 것 X
        for(int j=1;j<=num;j++){
            if(j % 2 == 0) s[j - 1] = '박'; // " " -> x
            else s[j - 1] = '수';
        }

        System.out.println(new String(s));
    }
}
