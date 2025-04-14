package org.pack.m04.apr_2;

import java.util.*;

public class 더_맵게 {
    public static void main(String[] args) {
        System.out.println("2 : " + solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.offer(s);
        }

        while (queue.size() >= 2 && queue.peek() < K) {
            int one = queue.poll();
            int two = queue.poll();

            queue.offer(one + (two * 2));
            answer++;
        }

        if (queue.peek() < K) {
            return -1;
        }

        return answer;
    }
}
