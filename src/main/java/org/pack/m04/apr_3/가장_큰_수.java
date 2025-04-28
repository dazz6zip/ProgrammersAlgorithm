package org.pack.m04.apr_3;

import java.util.*;

public class 가장_큰_수 {
    public static void main(String[] args) {
        System.out.println("6210 : " + solution(new int[]{6, 10, 2}));
        System.out.println("9534330 : " + solution(new int[]{3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(Integer.toString(number));
        }

        list.sort((a, b) -> (b + a).compareTo(a + b));
        // b + a , a + b 비교

        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(l);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
