package org.pack.m03.mar_4;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        System.out.println("2, 1 : " + Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println("1, 3, 2 : " + Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

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
