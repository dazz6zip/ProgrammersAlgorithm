package org.pack.jan_3.Lv1_신규아이디추천;

public class hyo {
    public String solution(String new_id) {
        // 1. 소문자로 변환
        new_id = new_id.toLowerCase();

        // 2. 허용된 문자(소문자, 숫자, -, _, .)만 남기기
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. 연속된 마침표(.)를 하나로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4. 처음이나 끝에 위치한 마침표(.) 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 5. 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. 길이가 16자 이상이면 15자로 줄이고, 끝이 .이면 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        }

        // 7. 길이가 2자 이하라면 마지막 문자를 추가하여 길이를 3으로 맞춤
        StringBuilder sb = new StringBuilder(new_id);
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}
