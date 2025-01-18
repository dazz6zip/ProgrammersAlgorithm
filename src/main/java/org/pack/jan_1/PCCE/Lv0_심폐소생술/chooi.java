package org.pack.jan_1.PCCE.Lv0_심폐소생술;

public class chooi {
    public int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for(int i = 0; i < cpr.length; i++){
            for(int j = 0; j < basic_order.length; j++){
                if(cpr[i].equals(basic_order[j])){
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;  // 반환 타입이 void로 명시되어 있다면 반환값이 필요 없지만 int로 명시되어 있기 때문에 int인 answer 반환
    }
}
