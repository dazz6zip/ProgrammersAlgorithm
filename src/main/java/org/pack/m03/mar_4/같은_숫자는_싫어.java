package org.pack.m03.mar_4;

import java.util.*;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        System.out.println("1, 3, 0, 1 : " + Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println("4, 3 : " + Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }

    public static int[] solution(int[] arr) {

        Deque<Integer> d = new ArrayDeque<>();
        for (int a : arr) {
            if (d.isEmpty() || d.peekLast() != a) {
                d.addLast(a);
            }
        }

        return d.stream().mapToInt(i -> i).toArray();

    }
}
