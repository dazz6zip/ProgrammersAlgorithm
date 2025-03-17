package org.pack.m03.mar_3;

import java.util.*;

public class 의상 {
    public static void main(String[] args) {
        System.out.println("5 : " + solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println("3 : " + solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        // 경우의 수
        // (종류 1 의 개수 + 1) * ... *  (종류 N 의 개수 + 1) - 1
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        int result = 1;
        for (String category : map.keySet()) {
            result *= (map.get(category) + 1);
        }

        return result - 1;
    }
}
