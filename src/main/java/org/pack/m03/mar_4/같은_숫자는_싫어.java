package org.pack.m03.mar_4;

import java.util.*;

public class 같은_숫자는_싫어 {
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
