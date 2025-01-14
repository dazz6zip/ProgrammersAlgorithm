package org.pack.jan_1.PCCE.Lv1_공원;

import java.util.Arrays;
import java.util.Collections;

public class dazz6 {
    public static void main(String[] args) {
        dazz6 dazz6 = new dazz6();
        int[] aa = {5, 3, 2};
        String[][] bb = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        System.out.println(dazz6.solution(aa, bb));
    }

    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        // 내림차순
        mats = Arrays.stream(mats) // array -> stream
                .boxed() // reverseOrder 사용을 위해 int -> Integer
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue) // Integer -> int
                .toArray(); // stream -> array

        for (int mat : mats) {
            for (int w = 0; w < park.length; w++) {
                int temp = -1;
                for (int h = 0; h < park[0].length; h++) {

                    // 순회 중에 -1 (비어 있는 자리) 발견시
                    if (park[w][h].equals("-1")) {

                        // 비어 있는 자리 width 에서 최초 발견시 temp에 h 저장
                        if (temp == -1) {
                            temp = h;
                        }

                        // h(현재 위치) 부터 temp(빈 첫 h)까지의 갯수가 mat 길이
                        if (h - temp + 1 == mat) {
                            boolean b = true;

                            // temp 초기 지점부터 mat 길이만큼 아래로 가능 여부 확인
                            for (int i = 0; i < mat; i++) {

                                // 공원 크기 넘어가면 불가능, break
                                if (w + i >= park.length) {
                                    b = false;
                                    break;
                                }

                                for (int j = temp; j < temp + mat; j++) {

                                    // 현재 위치가 비어있지 않으면 불가능, break
                                    if (!park[w + i][j].equals("-1")) {
                                        b = false;
                                        break;
                                    }
                                }

                                // 불가능일 경우 (b == false) break
                                if (!b) {
                                    break;
                                };
                            }

                            // b == true (설치 가능) 인 mat 길이 반환
                            if (b) {
                                return mat;
                            };
                        }

                        // 순회 중 -1가 아닌 자리일 시 temp 초기화
                    } else {
                        temp = -1;
                    }
                }
            }
        }
        return answer;
    }
}
