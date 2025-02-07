package org.pack.jan_3.Lv1_비밀지도;

public class hyo {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i]; // 지도 1과 지도 2를 OR 연산
            StringBuilder line = new StringBuilder();

            for (int j = 0; j < n; j++) {
                line.append((combined & (1 << (n - j - 1))) > 0 ? "#" : " ");
            }

            result[i] = line.toString();
        }

        return result;
    }
}
