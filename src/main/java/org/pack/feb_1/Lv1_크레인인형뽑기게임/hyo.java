package org.pack.feb_1.Lv1_크레인인형뽑기게임;

import java.util.Stack;

public class hyo {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int removedCount = 0;

        for (int move : moves) {
            int column = move - 1;

            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 0) {
                    int doll = board[i][column];
                    board[i][column] = 0; // 인형을 뽑았으므로 빈 칸 처리

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop(); // 같은 인형이면 제거
                        removedCount += 2;
                    } else {
                        stack.push(doll);
                    }
                    break; // 하나의 인형만 뽑으면 종료
                }
            }
        }
        return removedCount;
    }
}
