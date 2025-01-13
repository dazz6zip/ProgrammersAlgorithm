package org.pack.jan_1.PCCP.Lv1_동영상재생기;

public class dazz6 {
    public static void main(String[] args) {
        dazz6 dazz6 = new dazz6();
        String[] aa = {"next", "prev"};
        System.out.println(dazz6.solution("34:33", "13:00", "00:55", "02:55", aa));

        String[] bb = {"prev", "next", "next"};
        System.out.println(dazz6.solution("10:55", "00:05", "00:15", "06:55", bb));

        String[] cc = {"next"};
        System.out.println(dazz6.solution("07:22", "04:05", "00:15", "04:07", cc));
    }

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
