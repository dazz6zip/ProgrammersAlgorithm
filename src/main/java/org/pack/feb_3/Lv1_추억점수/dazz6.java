package org.pack.feb_3.Lv1_추억점수;

import java.util.*;

public class dazz6 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            m.put(name[i], yearning[i]);
        }

        List<Integer> l = new ArrayList<>();
        for (String[] p : photo) {
            int temp = 0;
            for (String pc : p) {
                temp += m.getOrDefault(pc, 0);
            }
            l.add(temp);
        }

        return l.stream().mapToInt(i -> i).toArray();
    }
}
