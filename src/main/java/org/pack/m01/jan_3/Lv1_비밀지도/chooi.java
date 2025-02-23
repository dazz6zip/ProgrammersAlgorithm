package org.pack.m01.jan_3.Lv1_비밀지도;

public class chooi {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n]; // 결과를 저장할 배열

        for (int i = 0; i < n; i++) {
            // 1. 지도 1과 지도 2를 OR 연산
            int combined = arr1[i] | arr2[i];

            // 2. OR 결과를 이진수로 변환 후, "벽"과 "공백"으로 변환
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((combined & (1 << (n - j - 1))) > 0) { // 비트가 1이면 "벽"
                    line.append("#");
                } else { // 비트가 0이면 "공백"
                    line.append(" ");
                }
            }

            // 3. 결과를 문자열로 저장
            answer[i] = line.toString();
        }

        return answer;
    }
}