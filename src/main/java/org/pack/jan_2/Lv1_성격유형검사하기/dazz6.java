package org.pack.jan_2.Lv1_성격유형검사하기;

import java.util.*;

public class dazz6 {
    public static void main(String[] args) {
        String[] s = {"AN", "CF", "MJ", "RT", "NA"};
        int[] c = {5, 3, 2, 7, 5};

        String[] ss = {"TR", "RT", "TR"};
        int[] cc = {7, 1, 3};

        System.out.println("TCMA : " + new dazz6().solution(s, c));
        System.out.println("RCJA : " + new dazz6().solution(ss, cc));
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        for (String type : new String[]{"R", "T", "C", "F", "J", "M", "A", "N"}) {
            map.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String[] s = survey[i].split("");

            if (choices[i] < 4) {
                map.put(s[0], map.get(s[0]) + (4 - choices[i]));
            } else if (choices[i] > 4) {
                map.put(s[1], map.get(s[1]) + (choices[i] - 4));
            }
        }

        String[][] types = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        for (String[] type : types) {
            String f = type[0];
            String s = type[1];

            if (map.get(f) < map.get(s)) {
                answer.append(s);
            } else {
                answer.append(f);
            }
        }

        return answer.toString();
    }
}
