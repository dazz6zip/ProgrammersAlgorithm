package org.pack.m01.jan_3.Lv1_실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println("1) 3,4,2,1,5 : " + Arrays.toString(new dazz6().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println("2) 4,1,2,3 : " + Arrays.toString(new dazz6().solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public int[] solution(int N, int[] stages) {
        double[][] result = new double[N][2];

        int[] cbs = new int[N + 2];
        int c = stages.length;

        for (int s : stages) {
            if (s <= N) {
                cbs[s]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            double temp = (c == 0) ? 0 : (double) cbs[i] / c;
            result[i - 1][0] = i;
            result[i - 1][1] = temp;
            c -= cbs[i];
        }

        Arrays.sort(result, (a, b) -> {
            if (b[1] != a[1]) {
                return Double.compare(b[1], a[1]);
            }
            return Double.compare(a[0], b[0]);
        });

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add((int) result[i][0]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
