package org.pack.m02.feb_1.Lv1_3진법뒤집기;

public class dazz6 {
    public int solution(int n) {
        String c = Integer.toString(n, 3);
        String cr = new StringBuilder(c).reverse().toString();

        return Integer.parseInt(cr, 3);
    }
}
