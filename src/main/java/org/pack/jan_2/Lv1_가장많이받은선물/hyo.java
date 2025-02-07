package org.pack.jan_2.Lv1_가장많이받은선물;

import java.util.HashMap;

public class hyo {
    public int solution(String[] friends, String[] gifts) {
        int maxGifts = 0;
        int n = friends.length;

        // 친구 이름을 인덱스로 매핑
        HashMap<String, Integer> friendIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        // 선물 지수 배열 및 주고받은 선물 기록 배열
        int[] giftScore = new int[n];
        int[][] giftHistory = new int[n][n];

        // 선물 기록 저장
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int sender = friendIndex.get(temp[0]);
            int receiver = friendIndex.get(temp[1]);

            giftScore[sender]++;
            giftScore[receiver]--;
            giftHistory[sender][receiver]++;
        }

        // 다음 달 가장 많이 받을 선물 개수 계산
        for (int i = 0; i < n; i++) {
            int numGifts = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                // (1) i가 j보다 선물을 더 줬으면 i가 더 받음
                if (giftHistory[i][j] > giftHistory[j][i]) {
                    numGifts++;
                } 
                // (2) 주고받은 선물 개수가 같다면, 선물 지수가 높은 사람이 받음
                else if (giftHistory[i][j] == giftHistory[j][i] && giftScore[i] > giftScore[j]) {
                    numGifts++;
                }
            }
            maxGifts = Math.max(maxGifts, numGifts);
        }

        return maxGifts;
    }
}
