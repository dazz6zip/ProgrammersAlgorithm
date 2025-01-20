package org.pack.jan_2.Lv1_가장많이받은선물;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dazz6 {
    public static void main(String[] args) {
        // 기록 o : 더 많은 선물을 준 사람이 다음 달에 하나 받음
        // 기록 x : 선물 지수가 더 큰 사람이 다음 달에 하나 받음
        // 선물 지수 : 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺸 값
        // 선물 지수도 같으면 선물 주고받음 없음

        // String[] friends : 친구들의 이름을 담은 1차원 배열
        // String[] gifts : 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 배열

        // 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수 return

        dazz6 dazz6 = new dazz6();
        String[] input1 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] input2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(dazz6.solution(input1, input2));
    }
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> send = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>();

        for (String friend : friends) {
            send.put(friend, 0);
            receive.put(friend, 0);
        }

        List<Map<String, String>> list = new ArrayList<>();

        for (String gift : gifts) {
            String[] giftConvert = gift.split(" ");
            String sender = giftConvert[0];
            String receiver = giftConvert[1];

            Map<String, String> map = new HashMap<>();
            map.put(sender, receiver);
            list.add(map);

            send.put(sender, send.get(sender) + 1);
            receive.put(receiver, receive.get(receiver) + 1);
        }

        return answer;
    }
}
