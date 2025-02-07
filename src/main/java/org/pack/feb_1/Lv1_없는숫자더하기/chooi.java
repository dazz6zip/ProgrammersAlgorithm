package org.pack.feb_1.Lv1_없는숫자더하기;
import java.util.*;
public class chooi {
    public int solution(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : numbers) {
            numSet.add(num); // numbers를 Set에 저장
        }

        int totalSum = 0;
        for (int i = 0; i <= 9; i++) {
            if (!numSet.contains(i)) { // 없는 숫자만 더하기
                totalSum += i;
            }
        }

        return totalSum;
    }
}