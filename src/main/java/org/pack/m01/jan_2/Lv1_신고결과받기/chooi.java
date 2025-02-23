package org.pack.m01.jan_2.Lv1_신고결과받기;

import java.util.*;

public class chooi {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 신고 내역을 정리하기 (중복 제거)
        Map<String, Set<String>> reportMap = new HashMap<>(); // 신고 당한 유저 → 신고한 유저 목록
        for (String r : report) {
            String[] parts = r.split(" "); // "신고자 신고당한유저" 분리
            String reporter = parts[0]; // 신고자
            String reported = parts[1]; // 신고당한 유저
            reportMap.putIfAbsent(reported, new HashSet<>());
            reportMap.get(reported).add(reporter); // 신고자를 추가
        }

        // 2. 정지 대상 유저 판단하기
        Set<String> bannedUsers = new HashSet<>(); // 정지 대상 유저
        for (String user : reportMap.keySet()) {
            if (reportMap.get(user).size() >= k) { // 신고 횟수가 k 이상이면
                bannedUsers.add(user);
            }
        }

        // 3. 결과 메일 횟수 계산하기
        Map<String, Integer> mailCount = new HashMap<>(); // 유저별 메일 수
        for (String user : id_list) {
            mailCount.put(user, 0); // 초기화
        }
        for (String banned : bannedUsers) {
            for (String reporter : reportMap.get(banned)) {
                mailCount.put(reporter, mailCount.get(reporter) + 1); // 신고자에게 메일 추가
            }
        }

        // 4. 결과 배열 생성하기
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]); // 유저별 메일 수를 결과에 추가
        }

        return answer;
    }
}