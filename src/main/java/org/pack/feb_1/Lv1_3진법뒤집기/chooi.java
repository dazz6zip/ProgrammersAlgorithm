package org.pack.feb_1.Lv1_3진법뒤집기;

public class chooi {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toString(n, 3));  // 주어진 숫자를 3진법으로 변환
        sb = sb.reverse();
        answer = Integer.parseInt(sb.toString(), 3);
        return  answer;
    }
}
