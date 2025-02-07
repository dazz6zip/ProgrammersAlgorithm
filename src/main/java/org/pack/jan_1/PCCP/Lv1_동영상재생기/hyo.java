package org.pack.jan_1.PCCP.Lv1_동영상재생기;

public class hyo {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = stringToInt(video_len);
        int posSec = stringToInt(pos);
        int opStartSec = stringToInt(op_start);
        int opEndSec = stringToInt(op_end);

        posSec = adjustForOpening(posSec, opStartSec, opEndSec);

        for (String command : commands) {
            if (command.equals("prev")) {
                posSec = Math.max(posSec - 10, 0);
            } else if (command.equals("next")) {
                posSec = Math.min(posSec + 10, videoLenSec);
            }
            posSec = adjustForOpening(posSec, opStartSec, opEndSec);
        }

        return String.format("%02d:%02d", posSec / 60, posSec % 60);
    }

    private int stringToInt(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private int adjustForOpening(int currentPos, int opStart, int opEnd) {
        return (currentPos >= opStart && currentPos <= opEnd) ? opEnd : currentPos;
    }
}
