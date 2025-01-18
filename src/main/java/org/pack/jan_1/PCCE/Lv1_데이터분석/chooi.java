package org.pack.jan_1.PCCE.Lv1_데이터분석;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class chooi {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터 이름과 인덱스를 저장할 맵
        HashMap<String, Integer> data_type = new HashMap<>();
        data_type.put("code", 0);
        data_type.put("date", 1);
        data_type.put("maximum", 2);
        data_type.put("remain", 3);

        // List<int[]>로 필터링된 데이터를 저장
        List<int[]> filtered_data = new ArrayList<>();
        for (int[] d : data) {
            if (d[data_type.get(ext)] < val_ext) { // 필터링 조건
                filtered_data.add(d);
            }
        }

        // sort_by를 기준으로 오름차순 정렬
        filtered_data.sort((a, b) -> Integer.compare(a[data_type.get(sort_by)], b[data_type.get(sort_by)]));

        // List<int[]>를 int[][]로 변환
        int[][] answer = new int[filtered_data.size()][];
        for (int i = 0; i < filtered_data.size(); i++) {
            answer[i] = filtered_data.get(i);
        }

        return answer;
    }
}
