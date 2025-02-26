package org.pack.m02.feb_3.Lv1_달리기경주;

import java.util.HashMap;
import java.util.Map;

public class hyo {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndex = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = playerIndex.get(calling);
            if (idx > 0) { // 맨 앞이 아니라면 교체 가능
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;

                playerIndex.put(calling, idx - 1);
                playerIndex.put(temp, idx);
            }
        }
        return players;
    }
}
