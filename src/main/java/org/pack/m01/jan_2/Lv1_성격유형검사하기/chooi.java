package org.pack.m01.jan_2.Lv1_성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class chooi {
    public String solution(String[] survey, int[] choices) {
        // 1. 각 성격 유형의 점수를 저장할 맵
        Map<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);

        // 2. survey와 choices를 기반으로 점수 계산
        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);  // 왼쪽 유형
            char right = survey[i].charAt(1); // 오른쪽 유형
            int choice = choices[i];

            if (choice <= 3) { // 비동의
                scoreMap.put(left, scoreMap.get(left) + (4 - choice));
            } else if (choice >= 5) { // 동의
                scoreMap.put(right, scoreMap.get(right) + (choice - 4));
            }
            // choice == 4인 경우는 점수 변화 없음
        }

        // 3. 결과 계산 (지표별로 높은 점수 성격 유형 선택)
        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T'); // 1번 지표
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F'); // 2번 지표
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M'); // 3번 지표
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N'); // 4번 지표

        return result.toString();
    }
}