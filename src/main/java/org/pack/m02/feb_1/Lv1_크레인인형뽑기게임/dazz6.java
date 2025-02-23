package org.pack.m02.feb_1.Lv1_크레인인형뽑기게임;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public int solution(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();
        int r = 0;
        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    if (!list.isEmpty() && list.get(list.size() - 1) == board[i][m - 1]) {
                        list.remove(list.size() - 1);
                        r += 2;
                    } else {
                        list.add(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        return r;
    }
}
