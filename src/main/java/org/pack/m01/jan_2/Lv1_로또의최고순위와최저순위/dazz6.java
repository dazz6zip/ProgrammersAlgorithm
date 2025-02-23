package org.pack.m01.jan_2.Lv1_로또의최고순위와최저순위;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 6;
        for (int i = 1; i < 7; i++) {
            map.put(i, count);
            count--;
        }

        int rightCount = 0;
        int unknownCount = 0;

        for (int l : lottos) {
            if (l != 0) {
                for (int w : win_nums) {
                    if (l == w) {
                        rightCount++;
                    }
                }
            } else {
                unknownCount++;
            }
        }

        return new int[]{map.get(Math.max(1, rightCount + unknownCount)), map.get(Math.max(1, rightCount))};
    }
}
