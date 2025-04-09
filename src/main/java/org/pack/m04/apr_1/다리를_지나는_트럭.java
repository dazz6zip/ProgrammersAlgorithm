package org.pack.m04.apr_1;

import java.util.*;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        System.out.println("8 : " + solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println("101 : " + solution(100, 100, new int[]{10}));
        System.out.println("110 : " + solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int t = 0;
        int s = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        while (idx < truck_weights.length) {
            t++;

            s -= queue.poll();

            if (s + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                s += truck_weights[idx];
                idx++;
            } else {
                queue.offer(0);
            }
        }

        return t + bridge_length;
    }
}
