package org.pack.m01.jan_1.PCCE.Lv0_피타고라스의정리;

import java.util.Scanner;

public class dazz6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (int) (Math.pow(c, 2) - Math.pow(a, 2));

        System.out.println(b_square);
    }
}
