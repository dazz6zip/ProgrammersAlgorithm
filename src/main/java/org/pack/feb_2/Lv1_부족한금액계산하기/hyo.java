package org.pack.feb_2.Lv1_부족한금액계산하기;

public class hyo {
    public long solution(int price, int money, int count) {
        long answer = -money;
        for (int i = 1; i <= count; i++){
            answer += price * i;
        }
        return (answer > 0) ? answer : 0;
    }
}
