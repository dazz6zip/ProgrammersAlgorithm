package org.pack.feb_2.Lv1_소수만들기;

public class dazz6 {
    public static void main(String[] args) {
        System.out.println(new dazz6().solution(new int[]{1, 2, 3, 4}));
        System.out.println(new dazz6().solution(new int[]{1, 2, 7, 6, 4}));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if(i != j && j != k ) {
                        int temp = nums[i] + nums[j] + nums[k];
                        answer = check(temp) ? answer + 1 : answer;
                    }
                }
            }
        }
        return answer;
    }

    public boolean check(int temp) {
        for (int i = 2; i <= temp; i++) {
            if (temp % i == 0 && temp != i) {
                return false;
            }
        }
        return true;
    }
}
