package org.pack.m05.mar_2;

public class 피로도 {
    public static void main(String[] args) {
        System.out.println("3 : " + solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, dungeons, visited, 0);
    }

    private static int dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        int max = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                int result = dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                max = Math.max(max, result);
                visited[i] = false;
            }
        }

        return max;
    }
}
