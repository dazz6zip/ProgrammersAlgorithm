package org.pack.jan_1.PCCE.Lv1_데이터분석;

import java.util.ArrayList;
import java.util.List;

public class hyo {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filteredList = new ArrayList<>();
        int extIndex = searchCategory(ext);
        int sortIndex = searchCategory(sort_by);

        // 필터링
        for (int[] d : data) {
            if (d[extIndex] < val_ext) {
                filteredList.add(d);
            }
        }

        // 정렬
        filteredList.sort((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));

        // 리스트를 배열로 변환
        return filteredList.toArray(new int[0][0]);
    }

    private int searchCategory(String s) {
        return switch (s) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            default -> 3;
        };
    }
}
