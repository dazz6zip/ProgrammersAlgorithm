package org.pack.jan_1.PCCE.Lv1_공원;

import java.util.Arrays;
import java.util.Collections;

public class dazz6 {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        // 내림차순 정렬
        mats = Arrays.stream(mats) // array -> stream
                .boxed() // reverseOrder 사용을 위해 int -> Integer
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue) // Integer -> int
                .toArray(); // stream -> array

        for (int mat : mats) {
            for (int w = 0; w <= park.length - mat; w++) {
                for (int h = 0; h <= park[0].length - mat; h++) {
                    // park의 범위 내에서 반복
                    if (checkMatSize(park, w, h, mat)) {
                        // 배치 가능 (checkMatSize -> true)
                        return mat;
                    }
                }
            }
        }

        // 배치 불가 (for 탐색에서 공간 확보 실패)
        return answer;
    }

    private boolean checkMatSize(String[][] park, int w, int h, int matSize) {
        for (int i = 0; i < matSize; i++) {
            for (int j = 0; j < matSize; j++) {
                // 시작 위치에서 매트 사이즈만큼 전부 비어 있는지 (-1 인지) 탐색
                if (!park[w + i][h + j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
