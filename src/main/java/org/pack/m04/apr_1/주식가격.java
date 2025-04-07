package org.pack.m04.apr_1;

import java.util.*;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println("4, 3, 1, 1, 0 : " + Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int t = stack.pop();
                answer[t] = i - t;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int t = stack.pop();
            answer[t] = prices.length - 1 - t;
        }

        return answer;
    }
}
