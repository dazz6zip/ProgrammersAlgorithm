package org.pack.m01.jan_3.Lv1_다트게임;

public class hyo {
    public int solution(String dartResult) {
        int[] scores = new int[3];  // 3번의 기회 점수를 저장할 배열
        int scoreIndex = 0;  // 현재 점수 위치
        int length = dartResult.length();  

        for (int i = 0; i < length; i++) {
            char ch = dartResult.charAt(i);

            // 1. 숫자(점수) 처리
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (i + 1 < length && dartResult.charAt(i + 1) == '0') {
                    num = 10;
                    i++;  // 10은 두 자리 숫자니까 인덱스 추가 이동
                }
                scores[scoreIndex] = num;  // 점수 저장
            }

            // 2. 보너스 처리 (S, D, T)
            else if (ch == 'S' || ch == 'D' || ch == 'T') {
                if (ch == 'D') scores[scoreIndex] = (int) Math.pow(scores[scoreIndex], 2);
                if (ch == 'T') scores[scoreIndex] = (int) Math.pow(scores[scoreIndex], 3);
                scoreIndex++;  // 다음 점수로 이동
            }

            // 3. 옵션 처리 (*, #)
            else if (ch == '*' || ch == '#') {
                if (ch == '*') {
                    scores[scoreIndex - 1] *= 2;  // 현재 점수 2배
                    if (scoreIndex > 1) scores[scoreIndex - 2] *= 2;  // 이전 점수도 2배
                } else if (ch == '#') {
                    scores[scoreIndex - 1] *= -1;  // 현재 점수 마이너스로 변경
                }
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}
