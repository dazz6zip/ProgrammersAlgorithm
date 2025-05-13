package org.pack.m05.mar_2;

import java.util.*;

public class 카펫 {
    public static void main(String[] args) {
        System.out.println("4, 3 : " + Arrays.toString(solution(10, 2)));
        System.out.println("3, 3 : " + Arrays.toString(solution(8, 1)));
        System.out.println("8, 6 : " + Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int all = brown + yellow;
        for (int i = 3; i <= all; i++) {
            if (all % i != 0) {
                continue;
            }
            int j = all / i;

            if ((i - 2) * (j - 2) == yellow) {
                return new int[]{Math.max(i, j), Math.min(i, j)};
            }
        }

        return new int[]{0, 0};
    }
}
