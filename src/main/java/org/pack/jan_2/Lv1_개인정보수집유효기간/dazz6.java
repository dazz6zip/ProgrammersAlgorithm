package org.pack.jan_2.Lv1_개인정보수집유효기간;

import java.util.*;

public class dazz6 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(new dazz6().solution(today, terms, privacies)));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] ts = today.split("\\.");
        int tTi = Integer.parseInt(ts[2]) + (Integer.parseInt(ts[1]) * 28) + (Integer.parseInt(ts[0].substring(2)) * 28 * 12);
        Map<String, Integer> tm = new HashMap<>();

        for (String term : terms) {
            String[] trs = term.split(" ");
            tm.put(trs[0], Integer.parseInt(trs[1]));
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] ps = privacies[i].split(" ");
            String[] ps2 = ps[0].split("\\.");
            int pTi = Integer.parseInt(ps2[2]) + (Integer.parseInt(ps2[1]) * 28) + (Integer.parseInt(ps2[0].substring(2)) * 28 * 12);
            if ((pTi + (tm.get(ps[1]) * 28)) <= tTi) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
    
}
