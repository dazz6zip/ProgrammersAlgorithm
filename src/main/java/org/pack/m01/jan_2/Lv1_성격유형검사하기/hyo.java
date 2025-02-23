package org.pack.m01.jan_2.Lv1_성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class hyo {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];

            if (choice < 4) {
                char first = survey[i].charAt(0);
                scores.put(first, scores.getOrDefault(first, 0) + (4 - choice));
            } else if (choice > 4) {
                char second = survey[i].charAt(1);
                scores.put(second, scores.getOrDefault(second, 0) + (choice - 4));
            }
        }

        return new StringBuilder()
            .append(scores.getOrDefault('R', 0) >= scores.getOrDefault('T', 0) ? 'R' : 'T')
            .append(scores.getOrDefault('C', 0) >= scores.getOrDefault('F', 0) ? 'C' : 'F')
            .append(scores.getOrDefault('J', 0) >= scores.getOrDefault('M', 0) ? 'J' : 'M')
            .append(scores.getOrDefault('A', 0) >= scores.getOrDefault('N', 0) ? 'A' : 'N')
            .toString();
    }
}
