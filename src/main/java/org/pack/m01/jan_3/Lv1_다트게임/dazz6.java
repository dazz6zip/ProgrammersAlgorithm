package org.pack.m01.jan_3.Lv1_다트게임;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dazz6 {
    public int solution(String dartResult) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            String d = dartResult.substring(i, i + 1);
            if (d.matches("[SDT]")) {
                int temp = d.equals("S") ? 1 : d.equals("D") ? 2 : 3;
                map.put(count, (int) Math.pow(map.get(count), temp));
            } else if (d.equals("#") || d.equals("*")) {
                map.put(count, d.equals("#") ? map.get(count) * -1 : map.get(count) * 2);
                if (d.equals("*") && count > 1) {
                    map.put(count - 1, map.get(count - 1) * 2);
                }
            } else if (d.equals("1") && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                i++;
                map.put(++count, 10);
            } else {
                map.put(++count, Integer.parseInt(d));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer += entry.getValue();
        }

        return answer;
    }
}
