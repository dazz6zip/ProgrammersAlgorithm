package org.pack.jan_3.Lv1_신규아이디추천;

public class chooi {
    public String solution(String new_id) {
        // 배문자를 소문자로 변환
        new_id = new_id.toLowerCase();

        // 허용된 문자(소문자, 숫자, -, _, .)만 남기기
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 연속된 마침표(.)를 하나로 치환
        new_id = new_id.replaceAll("\\.+", ".");

        // 처음이나 끝에 위치한 마침표(.) 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 길이가 16자 이상이면 15자로 줄이고, 끝이 .이면 제거
        if (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
