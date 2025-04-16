package org.pack.m04.apr_2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
    }

    public static int solution(int[][] jobs) {

        // 요청 시간 기준 정렬
        PriorityQueue<int[]> notYet = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 소요 시간 기준 정렬
        PriorityQueue<int[]> arrive = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] job : jobs) {
            notYet.offer(job);
        }

        int now = 0;
        int totalTime = 0;
        int endCount = 0;

        while (endCount < jobs.length) {
            while (!notYet.isEmpty() && notYet.peek()[0] <= now) {
                // 아직 도착하지 않은 작업이 존재하고
                // 작업의 요청 시간이 현재 시각보다 같거나 빠르면
                // => 실행 가능한 상태가 되었으면

                arrive.offer(notYet.poll());
                // 도착한 작업이 저장돼 있는 PriorityQueue 에 삽입
            }

            if (!arrive.isEmpty()) {
                // 도착한 작업이 존재할 경우

                int[] job = arrive.poll();
                now += job[1];
                totalTime += (now - job[0]);
                endCount++;
            } else {
                now = notYet.peek()[0];
            }
        }

        return totalTime / jobs.length;
    }
}
