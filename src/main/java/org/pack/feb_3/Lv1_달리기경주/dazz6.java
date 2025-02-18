package org.pack.feb_3.Lv1_달리기경주;

import java.util.HashMap;
import java.util.Map;

public class dazz6 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            m.put(players[i], i);
        }

        for (String c : callings) {
            int i = m.get(c);
            if (i == 0) {
                continue;
            }

            String pn = players[i - 1];

            players[i - 1] = c;
            m.put(c, i - 1);

            players[i] = pn;
            m.put(pn, i);
        }

        return players;
    }
}
