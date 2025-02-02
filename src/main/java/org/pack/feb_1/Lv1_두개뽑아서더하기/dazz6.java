package org.pack.feb_1.Lv1_두개뽑아서더하기;

import java.util.*;

public class dazz6 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}
