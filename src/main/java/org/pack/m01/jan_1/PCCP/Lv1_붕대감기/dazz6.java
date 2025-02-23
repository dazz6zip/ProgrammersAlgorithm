package org.pack.m01.jan_1.PCCP.Lv1_붕대감기;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> attackTime = new HashMap<>();
        for (int[] attack : attacks) {
            attackTime.put(attack[0], attack[1]);
        }

        int maxHealth = health;
        int totalCount = attacks[attacks.length - 1][0] + 1;
        int stream = 0;

        for (int i = 0; i < totalCount; i++) {
            if (attackTime.containsKey(i)) {
                health -= attackTime.get(i);
                stream = 0;
                if (health <= 0) {
                    return -1;
                }
            } else {
                if (health < maxHealth) {
                    health += bandage[1];
                    stream += 1;
                    if (stream == bandage[0]) {
                        health += bandage[2];
                        stream = 0;
                    }
                }
                health = Math.min(maxHealth, health);
            }
        }
        return health;
    }
}
