package org.pack.m01.jan_2.Lv1_개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hyo {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expiredList = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();

        // 오늘 날짜 파싱
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8));

        // 약관별 유효기간 저장
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        // 개인정보 유효기간 검사
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String[] dateParts = parts[0].split("\\.");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            // 유효기간 추가
            month += termMap.get(parts[1]);

            // 월이 12를 초과하면 연도 조정
            while (month > 12) {
                month -= 12;
                year += 1;
            }

            // 오늘 날짜와 비교
            if (year < todayYear || 
                (year == todayYear && month < todayMonth) || 
                (year == todayYear && month == todayMonth && day <= todayDay)) {
                expiredList.add(i + 1);
            }
        }

        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
}
