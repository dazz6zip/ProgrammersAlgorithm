package org.pack.m01.jan_1.PCCE.Lv1_이웃한칸;

public class hyo {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 상하좌우 이동

        for (int[] dir : directions) {
            int nh = h + dir[0];
            int nw = w + dir[1];

            if (nh < 0 || nh >= n || nw < 0 || nw >= n) continue; // 범위 벗어나면 스킵

            if (board[nh][nw].equals(board[h][w])) count++; // 같은 색이면 카운트 증가
        }
        return count;
    }
}
