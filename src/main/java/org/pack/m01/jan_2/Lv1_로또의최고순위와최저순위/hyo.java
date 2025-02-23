package org.pack.m01.jan_2.Lv1_로또의최고순위와최저순위;

import java.util.HashSet;
import java.util.Set;

public class hyo {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        int matched = 0;
        int zeroCount = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matched++;
            }
        }

        int maxRank = Math.min(7 - (matched + zeroCount), 6);
        int minRank = Math.min(7 - matched, 6);

        return new int[]{maxRank, minRank};
    }
}
