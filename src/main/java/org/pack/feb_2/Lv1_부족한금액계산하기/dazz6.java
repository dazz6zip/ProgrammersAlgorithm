package org.pack.feb_2.Lv1_부족한금액계산하기;

public class dazz6 {
    public long solution(int price, int money, int count) {
        long result = 0;
        for (int i = 1; i <= count; i++) {
            result += (long)(price * i);
        }
        return Math.max(0, result - money);
    }

}
