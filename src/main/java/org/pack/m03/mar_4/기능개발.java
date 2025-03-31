package org.pack.m03.mar_4;

import java.util.*;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()) {
            int t = queue.poll();
            int c = 1;
            while (!queue.isEmpty() && t >= queue.peek()) {
                c++;
                queue.poll();
            }
            list.add(c);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
