package org.pack.jan_1.PCCE.Lv0_병과분류;

import java.util.Scanner;

public class chooi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String lastFourWords = code.substring(code.length()-4, code.length());
        /*
            substring(start, end) : 문자열에서 원하는 범위를 잘라낼 때 사용
            code.length() - 4 : 문자열의 끝에서 4글자 전의 위치를 계산
            code.length() : 문자열의 전체 길이를 반환
            즉, 4글자 전부터 ~ 끝까지~
         */

        // equals() : 문자열이 정확히 일치하는지 확인
        if(lastFourWords.equals("_eye")){
            System.out.println("Opthalmologyc");
        }

        else if("head".equals(lastFourWords)){
            System.out.println("Neurosurgery");
        }

        // contains() : 문자열 안에 "" 단어가 포함되어 있는지 확인
        else if(code.contains("infl")){
            System.out.println("Orthopedics");
        }

        // endsWith() : 문자열이 특정 접미사로 끝나는지 확인
        else if(code.endsWith("skin")){
            System.out.println("Dermatology");
        }


        else{
            System.out.println("direct recommendation");
        }
    }
}
