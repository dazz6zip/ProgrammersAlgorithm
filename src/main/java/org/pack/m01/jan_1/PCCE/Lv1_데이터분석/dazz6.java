package org.pack.m01.jan_1.PCCE.Lv1_데이터분석;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        int extConvert = searchCategory(ext);

        for (int[] d : data) {
            if (d[extConvert] < val_ext) {
                list.add(d);
            }
        }

        // List의 sort 사용시 두 개씩(a, b) 짝지어서 정렬하는 과정을 거침
        list.sort((a, b) -> {
            int sortConvert = searchCategory(sort_by);
            return Integer.compare(a[sortConvert], b[sortConvert]);
        });

        return list.toArray(new int[0][0]);
    }

    public int searchCategory(String s) {
        return switch (s) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            default -> 3;
        };
    }
}
