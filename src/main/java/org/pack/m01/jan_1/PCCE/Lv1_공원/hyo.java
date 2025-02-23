package org.pack.m01.jan_1.PCCE.Lv1_공원;

import java.util.Arrays;
import java.util.Collections;

public class hyo {
    public int solution(int[] mats, String[][] park) {
        // 돗자리를 내림차순 정렬
        mats = Arrays.stream(mats)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // 가장 큰 돗자리부터 배치 가능 여부 확인
        for (int mat : mats) {
            for (int w = 0; w <= park.length - mat; w++) {
                for (int h = 0; h <= park[0].length - mat; h++) {
                    if (checkMatSize(park, w, h, mat)) {
                        return mat; // 배치 가능하면 즉시 반환
                    }
                }
            }
        }

        return -1; // 배치할 수 있는 돗자리가 없음
    }

    private boolean checkMatSize(String[][] park, int w, int h, int matSize) {
        for (int i = 0; i < matSize; i++) {
            for (int j = 0; j < matSize; j++) {
                if (!park[w + i][h + j].equals("-1")) {
                    return false; // 사람이 있으면 배치 불가
                }
            }
        }
        return true;
    }
}
