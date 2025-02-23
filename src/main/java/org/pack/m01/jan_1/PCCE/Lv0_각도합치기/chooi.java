package org.pack.m01.jan_1.PCCE.Lv0_각도합치기;

import java.util.Scanner;

public class chooi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum_angle = (angle1 + angle2) % 360;

        System.out.println(sum_angle);
    }
}
