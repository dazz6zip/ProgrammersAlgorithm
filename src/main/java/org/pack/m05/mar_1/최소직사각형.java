package org.pack.m05.mar_1;

public class 최소직사각형 {
    public static void main(String[] args) {
        System.out.println("4000 : " + solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println("120 : " + solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println("133 : " + solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }

    public static int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            w = Math.max(w, max);
            h = Math.max(h, min);
        }
        return w * h;
    }
}
