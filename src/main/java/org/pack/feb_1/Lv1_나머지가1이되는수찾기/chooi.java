package org.pack.feb_1.Lv1_나머지가1이되는수찾기;

public class chooi {
    public int solution(int n) {
        int answer = 0;

        for(int i = 2; i <= n; i++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
