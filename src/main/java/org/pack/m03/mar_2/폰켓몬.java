package org.pack.m03.mar_2;

import java.util.*;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return Math.min(map.size(), nums.length / 2);
    }
}
