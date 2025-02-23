package org.pack.m01.jan_1.PCCE.Lv1_지폐접기;

public class dazz6 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletX = wallet[0];
        int walletY = wallet[1];
        int billX = bill[0];
        int billY = bill[1];

        while (Math.min(billX, billY) > Math.min(walletX, walletY) || Math.max(billX, billY) > Math.max(walletX, walletY)) {
            if (billX > billY) {
                billX /= 2;
            } else {
                billY /= 2;
            }
            answer++;
        }

        return answer;
    }
}
