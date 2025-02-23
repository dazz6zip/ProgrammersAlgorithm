package org.pack.m02.feb_3.Lv1_유연근무제;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        Map<Integer, Boolean> m = new HashMap<>();

        for (int i = 0; i < timelogs.length; i++) {
            m.put(i, true);
            int t = startday;

            for (int j = 0; j < 7; j++) {
                int dh = schedules[i] / 100;
                int dm = schedules[i] % 100 + 10;

                if (dm >= 60) {
                    dm -= 60;
                    dh += 1;
                }

                if (((timelogs[i][j] / 100) * 100 + (timelogs[i][j] % 100)) > (dh * 100 + dm) && t != 6 && t != 7) {
                    m.put(i, false);
                    break;
                }

                t = (t % 7) + 1;
            }
        }
        int result = 0;
        for (boolean value : m.values()) {
            if (value) {
                result++;
            }
        }
        return result;
    }
}
