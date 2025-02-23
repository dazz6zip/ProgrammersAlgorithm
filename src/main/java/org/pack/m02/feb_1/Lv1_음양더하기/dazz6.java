package org.pack.m02.feb_1.Lv1_음양더하기;

public class dazz6 {
    public int solution(int[] absolutes, boolean[] signs) {
        int p = 0;
        for (int i = 0; i < absolutes.length; i++) {
            p = signs[i] ? p + absolutes[i] : p - absolutes[i];
        }
        return p;
    }
}
