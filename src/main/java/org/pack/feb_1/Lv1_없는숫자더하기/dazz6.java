package org.pack.feb_1.Lv1_없는숫자더하기;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int n : numbers) {
            list.remove(list.indexOf(n));
        }

        return list.stream().mapToInt(n -> n).sum();
    }
}
