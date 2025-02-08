package org.pack.feb_1.Lv1_음양더하기;

public class hyo {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }
}
