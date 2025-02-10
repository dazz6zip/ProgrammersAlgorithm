package org.pack.feb_2.Lv1_부족한금액계산하기;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println("10 : " + new dazz6().solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long result = 0;
        for (int i = 1; i <= count; i++) {
            result += (long)(price * i);
        }
        return Math.max(0, result - money);
    }

}
