package org.pack.m02.feb_2.Lv1_소수만들기;

public class hyo {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    boolean isPrime = true;
                    for(int div=2; div<sum/2; div++){
                        if(sum%div==0){
                            isPrime = false;
                            break;
                        }
                    }
                    if(isPrime) answer++;
                }
            }
        }
        return answer;
    }
}
