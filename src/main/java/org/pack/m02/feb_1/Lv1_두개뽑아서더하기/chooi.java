package org.pack.m02.feb_1.Lv1_두개뽑아서더하기;

import java.util.*;

public class chooi {
    public int[] solution(int[] numbers) {
        Set<Integer> sumSet = new HashSet<>(); // 중복 제거를 위한 Set

        // 1. 모든 두 수의 합을 Set에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }

        // 2. Set을 List로 변환 후 정렬
        List<Integer> sortedList = new ArrayList<>(sumSet);
        Collections.sort(sortedList);

        // 3. List를 int[] 배열로 변환
        return sortedList.stream().mapToInt(Integer::intValue).toArray();
    }
}