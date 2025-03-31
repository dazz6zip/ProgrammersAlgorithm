package org.pack.m03.mar_5;

import java.util.*;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println("true : " + solution("()()"));
        System.out.println("true : " + solution("(())()"));
        System.out.println("false : " + solution(")()("));
        System.out.println("false : " + solution("(()("));
    }

    public static boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}
