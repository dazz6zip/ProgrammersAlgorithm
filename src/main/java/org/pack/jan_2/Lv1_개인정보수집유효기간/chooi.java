package org.pack.jan_2.Lv1_개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chooi {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();       // 파기해야 할 개인정보의 번호를 저장하는 리스트
        Map<String, Integer> termMap = new HashMap<>();     // 약관 종류와 유효기간을 저장하는 HashMap    termMap.put("A", 6) -> "A" 약관은 6개월 유효기간
        int date = getDate(today);

        // 약관 데이터를 HashMap에 저장
        /*
        term[0] : 약관 종류. "A"
        term[1] : 유효기간(개월 수). "6"
        결과 : termMap = {"A" -> 6, "B" -> 12, "C" -> 3}
         */
        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        // 개인정보의 유효기간 계산 및 파기 여부 확인
        for (int i = 0; i < privacies.length; i++) {
            // privacies 배열에서 하나씩 꺼내서 처리.
            // "2021.05.02 A" -> privacy[0] = "2021.05.02", privacy[1] = "A"
            String[] privacy = privacies[i].split(" ");

            // 유효기간 계산
            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
