package org.pack.jan_2.Lv1_신고결과받기;

import java.util.*;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new dazz6().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(new dazz6().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    public Integer[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
        }

        Set<String[]> reportArchive = new HashSet<>();
        for (String r : report) {
            String[] split = r.split(" ");

            reportCount.put(split[1], reportCount.get(split[1]) + 1);
            reportArchive.add(new String[]{split[0], split[1]});
        }

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            if (entry.getValue() >= k) {
                for (String[] s : reportArchive) {
                    if (s[1].equals(entry.getKey())) {
                        result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + 1);
                    }
                }
            }
        }

        return result.values().toArray(new Integer[0]);
    }


}
