package org.pack.m03.mar_3;

import java.util.*;

public class 베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<int[]>> byGenre = new HashMap<>();
        Map<String, Integer> sequence = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            sequence.put(genres[i], sequence.getOrDefault(genres[i], 0) + plays[i]);

            byGenre.putIfAbsent(genres[i], new ArrayList<>());
            byGenre.get(genres[i]).add(new int[]{plays[i], i});
        }

        List<String> keys = new ArrayList<>(sequence.keySet());
        keys.sort((x, y) -> sequence.get(y).compareTo(sequence.get(x)));

        for (String k : keys) {
            List<int[]> songs = byGenre.get(k);

            songs.sort((s1, s2) -> s1[0] == s2[0] ? Integer.compare(s1[1], s2[1]) : Integer.compare(s2[0], s1[0]));

            answer.add(songs.get(0)[1]);
            if (songs.size() > 1) {
                answer.add(songs.get(1)[1]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
