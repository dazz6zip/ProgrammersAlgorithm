package org.pack.m02.feb_1.Lv1_키패드누르기;

public class dazz6 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[][] k = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

        int[] ll = {3, 0};
        int[] lr = {3, 2};

        for (int n : numbers) {
            if (n % 3 == 1) {
                sb.append("L");
                ll = k[n];
            } else if (n == 0 || n % 3 == 2) {
                int dl = Math.abs(ll[0] - k[n][0]) + Math.abs(ll[1] - k[n][1]);
                int dr = Math.abs(lr[0] - k[n][0]) + Math.abs(lr[1] - k[n][1]);
                if (dl < dr) {
                    sb.append("L");
                    ll = k[n];
                } else if (dl > dr) {
                    sb.append("R");
                    lr = k[n];
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        ll = k[n];
                    } else {
                        sb.append("R");
                        lr = k[n];
                    }
                }
            } else {
                sb.append("R");
                lr = k[n];
            }
        }

        return sb.toString();
    }
}
