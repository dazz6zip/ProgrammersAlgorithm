package org.pack.m01.jan_3.Lv1_숫자문자열과영단어;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println(new dazz6().solution("23four5six7"));
    }

    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] temp = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i);
        }

        String[] convert = s.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < convert.length; i++) {
            if(Character.isDigit(convert[i].charAt(0))) {
                sb.append(Integer.parseInt(convert[i]));
            } else {
                for (int j = 3; j <= 5; j++) {
                    if(i + j <= convert.length) {
                        int f = map.getOrDefault(s.substring(i, i + j), -1);
                        if (f >= 0) {
                            sb.append(f);
                        }
                    }

                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
