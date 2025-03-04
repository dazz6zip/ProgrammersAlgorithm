package org.pack.m03.mar_1.Lv2_퍼즐게임챌린지;

public class dazz6 {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;

        while (min < max) {
            int mid = (min + max) / 2;
            long t = limit;
            boolean b = true;

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) {
                    t -= times[i];
                } else {
                    long temp = (long) (diffs[i] - mid) * ((i > 0 ? times[i - 1] : 0) + times[i]);
                    t -= (temp + times[i]);
                }

                if (t < 0) {
                    b = false;
                    break;
                }
            }

            if (b) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
