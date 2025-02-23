package org.pack.m02.feb_2.Lv1_예산;
import java.util.Arrays;

public class hyo {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int dpm:d){
            budget -= dpm;
            if(budget<0) break;
            answer++;
        }
        return answer;   
    }
}
