package org.pack.m03.mar_1.Lv2_충돌위험찾기;

import java.util.*;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println("1 : " + new dazz6().solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}}));
        System.out.println("9 : " + new dazz6().solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}}));
        System.out.println("0 : " + new dazz6().solution(new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}}, new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}}));
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        Queue<int[]>[] r = new LinkedList[routes.length];
        // FIFO 같은 시간 같은 위치 파악을 위한 Queue

        for (int i = 0; i < routes.length; i++) {
            r[i] = new LinkedList<>();
        }

        for (int i = 0; i < routes.length; i++) {
            int nx = points[routes[i][0] - 1][1];
            int ny = points[routes[i][0] - 1][0];

            r[i].add(new int[]{nx, ny});

            for (int j = 1; j < routes[i].length; j++) {
                int gx = points[routes[i][j] - 1][1];
                int gy = points[routes[i][j] - 1][0];

                while (gy != ny) {
                    if (gy > ny) {
                        ny++;
                    } else {
                        ny--;
                    }
                    r[i].add(new int[]{nx, ny});
                }

                while (gx != nx) {
                    if (gx > nx) {
                        nx++;
                    } else {
                        nx--;
                    }
                    r[i].add(new int[]{nx, ny});
                }
            }
        }

        int c = 0;

        while (c < routes.length) {
            int[][] map = new int[101][101];
            c = 0;

            for (int i = 0; i < routes.length; i++) {
                if (r[i].isEmpty()) {
                    c++;
                    continue;
                }
                int[] tmp = r[i].poll();
                map[tmp[0]][tmp[1]]++;
            }

            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
