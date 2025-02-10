package org.pack.feb_2.Lv1_예산;

import java.util.Arrays;

public class dazz6 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        int temp = 0;
        for (int i : d) {
            if (temp + i > budget) {
                break;
            }
            temp += i;
            answer++;
        }

        return answer;
    }
}
