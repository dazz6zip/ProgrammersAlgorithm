package org.pack.feb_1.Lv1_음양더하기;

public class chooi {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;

        for (int i = 0; i < absolutes.length; i++) {
            // signs[i]가 true면 그대로 더하고, false면 -1을 곱해서 빼기
            sum += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return sum;
    }
}