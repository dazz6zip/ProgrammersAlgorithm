package org.pack.feb_4.Lv1_택배상자꺼내기;

public class dazz6 {
    public int solution(int n, int w, int num) {
        int h = (int) Math.ceil((double) n / w);
        int[][] b = new int[h][w];

        int t = 1;
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w && t <= n; j++) {
                    b[i][j] = t++;
                }
            } else {
                for (int j = w - 1; j >= 0 && t <= n; j--) {
                    b[i][j] = t++;
                }
            }
        }

        int result = h;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (b[i][j] == num) {
                    result -= i;
                    if (b[h - 1][j] == 0) {
                        result -= 1;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
