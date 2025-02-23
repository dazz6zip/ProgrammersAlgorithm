package org.pack.m02.feb_2.Lv1_예산;

import java.util.Arrays;

public class chooi {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);     // 부서별 요청 금액을 오름차순 정렬
        int count = 0;      // 지원할 수 있는 부서 개수

        for(int cost : d) {     // 작은 금액부터 예산에서 차감
            if(budget >= cost) {
                budget -= cost;
                count++;
            } else {
                break;      // 예산이 부족하면 종료
            }
        }

        return count;
    }
}
