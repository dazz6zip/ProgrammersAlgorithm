package org.pack.jan_1.PCCE.Lv0_피타고라스의정리;

import java.util.Scanner;

public class chooi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        /*
        int b_square = (int) Math.pow(c, 2) - (int) Math.pow(a, 2);

            Math.pow(c, 2) : c의 제곱 값을 계산

            Math.pow()의 반환 타입은 double이므로 정수형 변수 b_square에 저장하기 위해 (int)를 사용해 형 변환
         */

        // 간단한 제곱 계산은 성능 최적화를 위해 직접 곱셈을 사용하는 것이 더 효율적
        int b_square = c*c - a*a;

        System.out.println(b_square);
    }
}
