package org.pack.jan_2.Lv1_신고결과받기;

import java.util.*;

public class dazz6 {
    public Integer[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportArchive = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
            reportArchive.put(id, new HashSet<>());
            result.put(id, 0);
        }

        for (String r : report) {
            String[] split = r.split(" ");

            if (!reportArchive.get(split[0]).contains(split[1])) {
                reportArchive.get(split[0]).add(split[1]);
                reportCount.put(split[1], reportCount.get(split[1]) + 1);
            }
        }

        for (Map.Entry<String, Integer> count : reportCount.entrySet()) {
            if (count.getValue() >= k) {
                String reported = count.getKey();
                for (Map.Entry<String, Set<String>> archive : reportArchive.entrySet()) {
                    if (archive.getValue().contains(reported)) {
                        result.put(archive.getKey(), result.get(archive.getKey()) + 1);
                    }
                }
            }
        }

        return Arrays.stream(id_list)
                .map(result::get)
                .toArray(Integer[]::new);
    }
}
