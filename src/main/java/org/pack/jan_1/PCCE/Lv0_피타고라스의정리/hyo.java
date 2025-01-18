package org.pack.jan_1.PCCE.Lv0_피타고라스의정리;

import java.util.Scanner;

public class hyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = c*c - a*a;

        System.out.println(b_square);
    }
}