package org.pack.m04.apr_3;

import java.util.*;

public class H_Index {
    public static void main(String[] args) {
        System.out.println("3 : " + solution(new int[]{3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for (int citation : citations) {
            list.add(citation);
        }

        list.sort(Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }

        return h;
    }
}
