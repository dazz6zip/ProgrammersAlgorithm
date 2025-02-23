package org.pack.m01.jan_1.PCCE.Lv0_수나누기;

import java.util.Scanner;

public class dazz6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for(int i=0; number > 1; i++){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}
