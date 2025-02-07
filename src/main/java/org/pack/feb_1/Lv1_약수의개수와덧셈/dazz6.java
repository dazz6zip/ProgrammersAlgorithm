package org.pack.feb_1.Lv1_약수의개수와덧셈;

public class dazz6 {
    public int solution(int left, int right) {
       int f = 0;
       for (int i = left; i <= right; i++) {
           int t = 0;
           for (int j = 1; j <= i; j++) {
               if(i % j == 0) {
                   t++;
               }
           }
           f = t % 2 == 0 ? f + i : f - i;
       }
       return f;
    }
}
