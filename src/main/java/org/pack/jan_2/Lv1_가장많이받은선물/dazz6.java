package org.pack.jan_2.Lv1_가장많이받은선물;

import java.util.HashMap;

public class dazz6 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[] giftScore = new int[friends.length];
        int[][] grid = new int[friends.length][friends.length];

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int sender = map.get(temp[0]);
            int receiver = map.get(temp[1]);
            giftScore[sender]++;
            giftScore[receiver]--;
            grid[sender][receiver]++;
        }

        for (int i = 0; i < friends.length; i++) {
            int num = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    if (grid[i][j] > grid[j][i]) {
                        num++;
                    } else if (grid[i][j] == grid[j][i] && giftScore[i] > giftScore[j]) {
                        num++;
                    }
                }
            }
            answer = Math.max(answer, num);
        }

        return answer;
    }
}
