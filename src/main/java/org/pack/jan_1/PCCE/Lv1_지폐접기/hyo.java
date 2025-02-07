package org.pack.jan_1.PCCE.Lv1_지폐접기;

public class hyo {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int bigW = Math.max(wallet[0], wallet[1]);
        int smallW = Math.min(wallet[0], wallet[1]);
        int bigB = Math.max(bill[0], bill[1]);
        int smallB = Math.min(bill[0], bill[1]);

        while(true){
            if(bigB <= bigW && smallB <= smallW) break;
            if(bigW < bigB || smallW < smallB){
                bigB = bigB / 2;
                answer++;
            }
            if(bigB < smallB){
                int temp = bigB;
                bigB = smallB;
                smallB = temp;
            }
        }

        return answer;
    }
}
