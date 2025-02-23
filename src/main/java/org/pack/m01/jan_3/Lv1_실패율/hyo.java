package org.pack.m01.jan_3.Lv1_실패율;

import java.util.*;

public class hyo {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2]; // 각 스테이지에 도달한 사람 수 저장
        for (int stage : stages) {
            stageCount[stage]++;
        }

        List<Stage> failureRates = new ArrayList<>();
        int players = stages.length; // 전체 도전자 수

        for (int i = 1; i <= N; i++) {
            if (players == 0) {
                failureRates.add(new Stage(i, 0)); // 스테이지에 도달한 사람이 없으면 실패율 0
            } else {
                failureRates.add(new Stage(i, (double) stageCount[i] / players));
                players -= stageCount[i]; // 남은 도전자 수 갱신
            }
        }

        // 실패율 기준으로 정렬 (내림차순), 실패율이 같으면 작은 번호 스테이지가 우선
        failureRates.sort((a, b) -> Double.compare(b.failure, a.failure) == 0 ? a.stage - b.stage : Double.compare(b.failure, a.failure));

        // 결과 배열로 변환하여 반환
        return failureRates.stream().mapToInt(s -> s.stage).toArray();
    }

    // 실패율 정보를 저장하는 클래스
    static class Stage {
        int stage;
        double failure;

        public Stage(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }
    }
}
