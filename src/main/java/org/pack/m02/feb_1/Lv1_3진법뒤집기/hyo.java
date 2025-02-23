package org.pack.m02.feb_1.Lv1_3진법뒤집기;

public class hyo {
    public int solution(int n) {
        String reversedBase3 = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        return Integer.parseInt(reversedBase3, 3);
    }
}
