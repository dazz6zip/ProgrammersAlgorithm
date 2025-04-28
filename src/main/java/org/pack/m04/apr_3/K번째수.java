package org.pack.m04.apr_3;

import java.util.*;

public class K번째수 {
    public static void main(String[] args) {
        System.out.println("5, 6, 3 : " + Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            for (int i = command[0] - 1; i <= command[1] - 1; i++) {
                list.add(array[i]);
            }
            Collections.sort(list);
            result.add(list.get(command[2] - 1));
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
