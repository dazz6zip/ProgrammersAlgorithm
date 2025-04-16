package org.pack.m04.apr_2;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        System.out.println("[0, 0] : " + Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println("[333, -45] : " + Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

    public static int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String o : operations) {
            StringTokenizer st = new StringTokenizer(o, " ");
            if (st.nextToken().equals("I")) {
                int input = Integer.parseInt(st.nextToken());
                map.put(input, map.getOrDefault(input, 0) + 1);
            } else if (!map.isEmpty()) {
                if (st.nextToken().equals("-1")) {
                    int min = map.firstKey();
                    if (map.get(min) == 1) {
                        map.remove(min);
                    } else {
                        map.put(min, map.get(min) - 1);
                    }
                } else {
                    int max = map.lastKey();
                    if (map.get(max) == 1) {
                        map.remove(max);
                    } else {
                        map.put(max, map.get(max) - 1);
                    }
                }
            }

        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{map.lastKey(), map.firstKey()};
    }
}
