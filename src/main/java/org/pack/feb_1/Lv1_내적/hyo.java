package org.pack.feb_1.Lv1_내적;

public class hyo {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
