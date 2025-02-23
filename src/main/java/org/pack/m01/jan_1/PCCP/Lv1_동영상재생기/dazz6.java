package org.pack.m01.jan_1.PCCP.Lv1_동영상재생기;

public class dazz6 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        // 동영상 길이
        int vlConvert = stringToInt(video_len);

        // 현재 재생 위치
        int posConvert = stringToInt(pos);

        // 오프닝 시작 시각
        int osConvert = stringToInt(op_start);

        // 오프닝 종료 시각
        int oeConvert = stringToInt(op_end);

        int result = openingCheck(posConvert, osConvert, oeConvert);

        for (String c : commands) {
            if (c.equals("prev")) {
                result = Math.max(result - 10, 0);
            } else {
                result = Math.min(result + 10, vlConvert);
            }
            result = openingCheck(result, osConvert, oeConvert);
        }

        answer = String.format("%02d:%02d", result / 60, result % 60);
        return answer;
    }

    public int stringToInt(String input) {
        String[] tempInput = input.split(":");
        return Integer.parseInt(tempInput[0]) * 60 + Integer.parseInt(tempInput[1]);
    }

    public int openingCheck(int now, int start, int end) {
        if (start <= now && now <= end) {
            return end;
        }
        return now;
    }
}
