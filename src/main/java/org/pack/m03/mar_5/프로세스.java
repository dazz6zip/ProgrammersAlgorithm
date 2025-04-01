package org.pack.m03.mar_5;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        System.out.println("1 : " + solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println("5 : " + solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        int c = 0;

        while (!queue.isEmpty()) {
            int[] sq = queue.poll();
            boolean b = true;

            for (int[] q : queue) {
                if (q[0] > sq[0]) {
                    b = false;
                    break;
                }
            }

            if (b) {
                c++;
                if (sq[1] == location) {
                    answer = c;
                    break;
                }
            } else {
                queue.offer(sq);
            }
        }

        return answer;
    }
}
