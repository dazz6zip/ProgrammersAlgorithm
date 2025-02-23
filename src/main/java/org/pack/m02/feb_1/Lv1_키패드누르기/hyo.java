package org.pack.m02.feb_1.Lv1_키패드누르기;

public class hyo {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        // 키패드 좌표 설정
        int[][] keypad = {
                {3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}
        };

        // 초기 손가락 위치 (왼손: *, 오른손: #)
        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int num : numbers) {
            // 왼손으로 누르는 숫자 (1, 4, 7)
            if (num % 3 == 1) {
                sb.append("L");
                left = keypad[num];
            }
            // 오른손으로 누르는 숫자 (3, 6, 9)
            else if (num % 3 == 0 && num != 0) {
                sb.append("R");
                right = keypad[num];
            }
            // 2, 5, 8, 0은 거리 계산 후 손 결정
            else {
                int leftDist = Math.abs(left[0] - keypad[num][0]) + Math.abs(left[1] - keypad[num][1]);
                int rightDist = Math.abs(right[0] - keypad[num][0]) + Math.abs(right[1] - keypad[num][1]);

                if (leftDist < rightDist) {
                    sb.append("L");
                    left = keypad[num];
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    right = keypad[num];
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = keypad[num];
                    } else {
                        sb.append("R");
                        right = keypad[num];
                    }
                }
            }
        }
        return sb.toString();
    }
}
