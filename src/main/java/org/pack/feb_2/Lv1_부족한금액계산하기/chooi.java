package org.pack.feb_2.Lv1_부족한금액계산하기;

public class chooi {
    public long solution(int price, int money, int count) {
        // 1부터 count까지의 합을 구하는 공식
        long total_cost = price * (long)(count * (count + 1) / 2);

        // 돈이 부족하면 부족한 금액을 반환, 부족하지 않으면 0을 반환
        return total_cost > money ? total_cost - money : 0;
    }
}
