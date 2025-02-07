package org.pack.feb_1.Lv1_내적;

public class dazz6 {
    public int solution(int[] a, int[] b) {
        int in = 0;
        for (int i = 0; i < a.length; i++) {
            in += (a[i] * b[i]);
        }
        return in;
    }
}
