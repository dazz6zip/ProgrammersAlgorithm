package org.pack.m01.jan_1.PCCE.Lv1_이웃한칸;

public class chooi {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 상하좌우

        for (int i = 0; i < 4; i++) {
            int dh = h + dir[i][0];
            int dw = w + dir[i][1];

            // 범위 벗어난 경우 무시
            if (dh < 0 || dh >= n || dw < 0 || dw >= n) continue;

            // 인접한 칸이 같은 색이면 카운트 증가
            if (board[dh][dw].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}
