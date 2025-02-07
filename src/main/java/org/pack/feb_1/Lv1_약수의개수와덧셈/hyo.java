package org.pack.feb_1.Lv1_약수의개수와덧셈;

public class hyo {
    public int solution(int left, int right) {
        int result = 0;
        for (int num = left; num <= right; num++) {
            result += isSquare(num) ? -num : num;
        }
        return result;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
