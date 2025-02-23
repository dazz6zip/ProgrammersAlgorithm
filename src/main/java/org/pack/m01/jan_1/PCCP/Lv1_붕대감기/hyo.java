package org.pack.m01.jan_1.PCCP.Lv1_붕대감기;

public class hyo {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력 저장
        int attackIdx = 0; // 공격 인덱스
        int stream = 0; // 연속 힐 카운트

        for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            if (attackIdx < attacks.length && time == attacks[attackIdx][0]) { 
                // 공격을 받는 경우
                health -= attacks[attackIdx][1];
                stream = 0; // 붕대 감기 중단
                attackIdx++; 

                if (health <= 0) return -1; // 체력이 0 이하이면 게임 오버
            } else {
                // 공격을 받지 않는 경우 힐
                health = Math.min(health + bandage[1], maxHealth);
                stream++;

                if (stream == bandage[0]) { // 연속 힐 성공 시 추가 회복
                    health = Math.min(health + bandage[2], maxHealth);
                    stream = 0; // 초기화
                }
            }
        }
        return health;
    }
}
