package org.pack.jan_3.Lv1_신규아이디추천;

public class dazz6 {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder(new_id.toLowerCase() // 소문자로 변환
                .replaceAll("[^a-z0-9-_.]", "")
                // a-z, 0-9, -, _, . 만 남기기
                .replaceAll("\\.{2,}", ".")
                // 마침표 여러 개 -> 한 개로 치환
                .replaceAll("^\\.|\\.$", ""));
                // 시작 / 끝에 있는 마침표 제거

        answer = new StringBuilder(answer.length() == 0 ? "a" : answer.toString());
        answer = new StringBuilder(answer.length() >= 16 ? answer.substring(0, 15).replaceAll("\\.$", "") : answer.toString());
        while (answer.length() < 3) {
            answer.append(answer.charAt(answer.length() - 1));
        }
        return answer.toString();
    }
}
