package org.pack.m01.jan_3.Lv1_비밀지도;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] a = proc(n, arr1);
        String[][] b = proc(n, arr2);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b.length; j++) {
                if(a[i][j].equals("1") || b[i][j].equals("1")) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
        }
        return result.toArray(new String[n]);
    }

    public String[][] proc(int n, int[] arr) {
        String[][] result = new String[n][n];
        for (int i = 0; i < n; i++) {
            String ss = String.format("%" + n + "s", Integer.toBinaryString(arr[i])).replace(' ', '0');
            for (int j = 0; j < n; j++) {
                result[i][j] = String.valueOf(ss.charAt(j));
            }
        }
        return result;
    }

}
