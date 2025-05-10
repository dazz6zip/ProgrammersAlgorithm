package org.pack.m05.mar_1;

import java.util.*;

public class 소수_찾기 {
    public static void main(String[] args) {
        System.out.println("3: " + solution("17"));
        System.out.println("2 : " + solution("011"));
    }

    public static int solution(String numbers) {
        List<Character> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(c);
        }

        Set<Integer> set = new HashSet<>();
        boolean[] use = new boolean[list.size()];

        for (int r = 1; r <= list.size(); r++) {
            Deque<Character> path = new ArrayDeque<>();
            dfs(list, use, path, set, r);
        }

        int c = 0;
        for (int n : set) {
            if (n < 2) {
                continue;
            }
            boolean b = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                c++;
            }
        }

        return c;
    }

    static void dfs(List<Character> list, boolean[] use, Deque<Character> path, Set<Integer> set, int r) {
        if (path.size() == r) {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (use[i]) {
                continue;
            }
            use[i] = true;
            path.addLast(list.get(i));
            dfs(list, use, path, set, r);
            path.removeLast();
            use[i] = false;
        }
    }
}
