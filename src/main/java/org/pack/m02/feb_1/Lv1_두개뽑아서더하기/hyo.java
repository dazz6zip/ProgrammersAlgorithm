package org.pack.m02.feb_1.Lv1_두개뽑아서더하기;

import java.util.Set;
import java.util.TreeSet;

public class hyo {
    public int[] solution(int[] numbers) {
        Set<Integer> sumSet = new TreeSet<>(); // 자동 정렬되는 TreeSet 사용

        // 모든 두 수의 합을 Set에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }

        // 정렬된 Set을 배열로 변환하여 반환
        return sumSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
