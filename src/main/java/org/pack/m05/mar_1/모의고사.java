package org.pack.m05.mar_1;

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        System.out.println("[1] : " + Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println("[1, 2, 3] : " + Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int len = answers.length;

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] s1Temp = new int[len];
        int[] s2Temp = new int[len];
        int[] s3Temp = new int[len];

        for (int i = 0; i < len; i++) {
            s1Temp[i] = s1[i % s1.length];
            s2Temp[i] = s2[i % s2.length];
            s3Temp[i] = s3[i % s3.length];
        }

        Map<Integer, Integer> s = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (answers[i] == s1Temp[i]) {
                s.put(1, s.getOrDefault(1, 0) + 1);
            }
            if (answers[i] == s2Temp[i]) {
                s.put(2, s.getOrDefault(2, 0) + 1);
            }
            if (answers[i] == s3Temp[i]) {
                s.put(3, s.getOrDefault(3, 0) + 1);
            }
        }

        int max = Collections.max(s.values());

        List<Integer> result = new ArrayList<>();
        for (int key : s.keySet()) {
            if (s.get(key) == max) {
                result.add(key);
            }
        }

        Collections.sort(result);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
