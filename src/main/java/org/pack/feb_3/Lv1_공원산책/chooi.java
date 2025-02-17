package org.pack.feb_3.Lv1_공원산책;

import java.util.HashMap;
import java.util.Map;

public class chooi {
    public int[] solution(String[] park, String[] routes) {
        // 시작 위치 찾기
        int startX = 0, startY = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 방향 이동 정의
        Map<String, int[]> directions = new HashMap<>();
        directions.put("N", new int[]{-1, 0});
        directions.put("S", new int[]{1, 0});
        directions.put("W", new int[]{0, -1});
        directions.put("E", new int[]{0, 1});

        // 명령 수행
        for(String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];      // 방향
            int steps = Integer.parseInt(split[1]);     // 이동거리
            int[] move = directions.get(dir);       // 방향 이동 값 가져오기

            int newX = startX, newY = startY;
            boolean canMove = true;

            for(int i = 1; i <= steps; i++) {
                int nextX = startX + move[0] * i;
                int nextY = startY + move[1] * i;

                // 공원을 벗어나면 중단
                if(nextX < 0 || nextX >= park.length || nextY < 0 || nextY >= park[0].length()) {
                    canMove = false;
                    break;
                }

                // 장애물(X)이 있으면 중단
                if(park[nextX].charAt(nextY) == 'X') {
                    canMove = false;
                    break;
                }

                // 이동 가능하면 최종 위치 저장
                newX = nextX;
                newY = nextY;
            }

            // 이동이 가능하다면 위치 업데이트
            if(canMove) {
                startX = newX;
                startY = newY;
            }
        }
        return new int[]{startX, startY};
    }
}
