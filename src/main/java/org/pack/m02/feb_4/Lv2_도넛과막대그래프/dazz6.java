package org.pack.m02.feb_4.Lv2_도넛과막대그래프;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer[]> map = new HashMap<>();
        // 노드 번호, {진출 간선 수, 진입 간선 수} 구조

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new Integer[]{0, 0});
            map.get(edge[0])[0]++;

            map.putIfAbsent(edge[1], new Integer[]{0, 0});
            map.get(edge[1])[1]++;
        }

        return check(map);
    }

    private int[] check(Map<Integer, Integer[]> map) {
        int c = 0;
        int d = 0;
        int s = 0;
        int e = 0;

        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            int f = entry.getValue()[0];
            int t = entry.getValue()[1];

            if (f >= 2 && t == 0) {
                // 생성 정점 : 나가는 간선 2개 이상, 들어오는 간선 없음
                c = entry.getKey();
            } else if (f == 0 && t > 0) {
                // 막대 그래프 : 나가는 간선 없음, 들어오는 간선 있음
                s++;
            } else if (f >= 2 && t >= 2) {
                // 8자 그래프 : 들어오는 간선 2개 이상, 나가는 간선 2개 이상
                e++;
            }
        }

        // 도넛 그래프 : 생성 정점의 진출 간선 수에서 막대 그래프, 8자 그래프 수 제외
        d = map.get(c)[0] - s - e;

        return new int[]{c, d, s, e};
    }
}
