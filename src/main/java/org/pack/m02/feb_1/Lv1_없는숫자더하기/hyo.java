package org.pack.m02.feb_1.Lv1_없는숫자더하기;

public class hyo {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers){
            sum -= i;
        }
        return sum;
    }
}
