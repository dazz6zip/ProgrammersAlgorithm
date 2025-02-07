package org.pack.jan_2.Lv1_가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

public class chooi {
    public int solution(String[] friends, String[] gifts) {
        // String을 Key로 Integer를 Value로 저장
        Map<String, Integer> map = new HashMap<>();
        // "이름"을 key로 저장하고 "해당 친구의 숫자 인덱스"를 value로 저장하는 자료구조

        // for문을 돌면서 친구 이름과 인덱스를 매핑
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        // 각 친구의 선물 지수(= 준 선물 - 받은 선물)
        int index[] = new int[friends.length];
        // 누가 누구에게 몇 개의 선물을 줬는지 저장
        int[][] record = new int[friends.length][friends.length];

        // 선물 기록 저장
        for (String str : gifts) {  // gifts 배열에서 하나씩 꺼내서 str 변수에 저장
            String[] cur = str.split(" ");
            index[map.get(cur[0])]++;   // 선물 준 사람의 선물 지수 증가
            index[map.get(cur[1])]--;   // 선물 받은 사람의 선물 지수 감소
            record[map.get(cur[0])][map.get(cur[1])]++; // 준 선물 개수
        }

        // 다음 달 선물 받을 개수 계산
        int ans = 0;
        /*
        i : 현재 비교하는 친구
        j : 비교 대상 친구
        cnt : i가 받을 선물 개수
         */
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                if (record[i][j] > record[j][i]) cnt++;
                else if (record[i][j] == record[j][i] && index[i] > index[j]) cnt++;
            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}
