package org.pack.feb_3.Lv2_비밀코드해독;

import java.util.ArrayList;
import java.util.List;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println("1) 3 : " + new dazz6().solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}, new int[]{2, 3, 4, 3, 3}));
        System.out.println("2) 5 : " + new dazz6().solution(15, new int[][]{{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}}, new int[]{2, 1, 3, 0, 1}));
    }

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
