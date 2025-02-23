package org.pack.m02.feb_1.Lv1_나머지가1이되는수찾기;

public class dazz6 {
    public int solution(int n) {
        int x = 0;
        while (true) {
            x++;
            if (n % x == 1) {
                return x;
            }
        }
    }
}
