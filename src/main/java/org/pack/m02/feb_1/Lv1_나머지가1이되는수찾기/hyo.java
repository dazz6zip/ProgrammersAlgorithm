package org.pack.m02.feb_1.Lv1_나머지가1이되는수찾기;

public class hyo {
    int solution(int n) {
        int answer = 0;
        while(true) {
                answer++;
                if(n%answer==1) break;
            }
        return answer;
    }
}
