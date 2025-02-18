package org.pack.feb_3.Lv1_공원산책;

public class dazz6 {
    public int[] solution(String[] park, String[] routes) {
        int w = park[0].length();
        int h = park.length;
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        for (String r : routes) {
            String[] rs = r.split(" ");
            int moveX = 0;
            int moveY = 0;

            switch (rs[0]) {
                case "N" -> moveX = -1;
                case "S" -> moveX = 1;
                case "E" -> moveY = 1;
                case "W" -> moveY = -1;
            }

            int nowX = startX;
            int nowY = startY;

            boolean b = true;

            for (int i = 1; i <= Integer.parseInt(rs[1]); i++) {
                int tempX = startX + (moveX * i);
                int tempY = startY + (moveY * i);
                if (tempX < 0 || tempX >= h || tempY < 0 || tempY >= w || park[tempX].charAt(tempY) == 'X') {
                    b = false;
                    break;
                }
                nowX = tempX;
                nowY = tempY;
            }

            if (b) {
                startX = nowX;
                startY = nowY;
            }
        }

        return new int[]{startX, startY};
    }
}
