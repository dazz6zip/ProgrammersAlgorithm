package org.pack.feb_1.Lv1_약수의개수와덧셈;

public class chooi {
    public int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                result -= i;
            } else {
                result += i;
            }
        }

        return result;
    }
}
