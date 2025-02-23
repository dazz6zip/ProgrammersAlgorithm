package org.pack.m01.jan_3.Lv1_실패율;

import java.util.*;

public class chooi {
    public int[] solution(int N, int[] stages) {
        // 각 스테이지에 도달한 사람 수 계산
        int[] stageCount = new int[N + 2]; // 인덱스 1~N을 사용, N+1은 클리어한 사람
        for (int stage : stages) {
            stageCount[stage]++;
        }

        // 각 스테이지의 실패율 계산
        List<Stage> failureRates = new ArrayList<>();
        int players = stages.length; // 전체 플레이어 수

        for (int i = 1; i <= N; i++) {
            if (players == 0) {
                failureRates.add(new Stage(i, 0)); // 도달한 사람이 없으면 실패율 0
            } else {
                failureRates.add(new Stage(i, (double) stageCount[i] / players));
                players -= stageCount[i]; // 다음 스테이지의 도전자 수 갱신
            }
        }

        // 실패율 기준으로 정렬 (내림차순), 실패율이 같다면 작은 번호 스테이지 먼저
        failureRates.sort((a, b) -> b.failure == a.failure ? a.stage - b.stage : Double.compare(b.failure, a.failure));

        // 정렬된 결과를 배열로 변환
        return failureRates.stream().mapToInt(s -> s.stage).toArray();
    }

    // 실패율을 저장할 클래스
    class Stage {
        int stage;
        double failure;

        public Stage(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }
    }
}