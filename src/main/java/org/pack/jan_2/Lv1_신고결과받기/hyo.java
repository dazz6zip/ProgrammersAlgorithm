package org.pack.jan_2.Lv1_신고결과받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class hyo {
    public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];
        Map<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        Map<String, Integer> reportedCountInfoMap = new HashMap<>();

        // 신고 정보 저장
        for (String reportInfo : report) {
            String[] parts = reportInfo.split(" ");
            String reporter = parts[0];  // 신고 한 사람
            String reported = parts[1];  // 신고 당한 사람

            reporterInfoMap.computeIfAbsent(reporter, v -> new HashSet<>()).add(reported);
        }

        // 신고 횟수 카운트
        for (HashSet<String> reportedUsers : reporterInfoMap.values()) {
            for (String reported : reportedUsers) {
                reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0) + 1);
            }
        }

        // 메일 발송 대상 확인
        for (int i = 0; i < idList.length; i++) {
            String user = idList[i];
            if (reporterInfoMap.containsKey(user)) {
                for (String reported : reporterInfoMap.get(user)) {
                    if (reportedCountInfoMap.getOrDefault(reported, 0) >= k) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
