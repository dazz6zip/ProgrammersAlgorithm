package org.pack.m02.feb_3.Lv2_비밀코드해독;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        List<Integer[]> list = create(n);

        for (Integer[] l : list) {
            List<Integer> temp = List.of(l);
            boolean b = true;

            for (int i = 0; i < q.length; i++) {
                int c = 0;
                int tn = 0;
                int qn = 0;

                while (tn < 5 && qn < 5) {
                    if (temp.get(tn) == q[i][qn]) {
                        c++;
                        tn++;
                        qn++;
                    } else if (temp.get(tn) < q[i][qn]) {
                        tn++;
                    } else {
                        qn++;
                    }
                }

                if (c != ans[i]) {
                    b = false;
                    break;
                }
            }

            if (b) {
                answer++;
            }
        }

        return answer;
    }

    public List<Integer[]> create(int n) {
        List<Integer[]> result = new ArrayList<>();

        for (int i = 1; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                for (int k = j + 1; k <= n - 2; k++) {
                    for (int l = k + 1; l <= n - 1; l++) {
                        for (int m = l + 1; m <= n; m++) {
                            result.add(new Integer[]{i, j, k, l, m});
                        }
                    }
                }
            }
        }

        return result;
    }
}
