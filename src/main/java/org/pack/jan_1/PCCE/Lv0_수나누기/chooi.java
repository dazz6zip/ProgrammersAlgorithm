package org.pack.jan_1.PCCE.Lv0_수나누기;

import java.util.Scanner;

public class chooi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();  // 4859
        int answer = 0;

        for(int i = 0; number > 0; i++){    // number가 0이 될 때까지
            answer += number % 100;
            number /= 100;
            /*
                1. 초기값 설정:
                   - 입력값: `number = 4859`
                   - `answer = 0` (결과를 저장할 변수)

                2. 첫 번째 반복:
                   - `number % 100`:
                     - `4859 % 100 = 59` (마지막 두 자리 추출).
                   - `answer += number % 100`:
                     - `answer = 0 + 59 = 59` (추출한 값을 answer에 더함).
                   - `number /= 100`:
                     - `number = 4859 / 100 = 48` (마지막 두 자리를 제거).

                3. 두 번째 반복:
                   - 이제 `number = 48`.
                   - `number % 100`:
                     - `48 % 100 = 48` (48은 두 자리 수이므로 그대로 나머지로 반환).
                   - `answer += number % 100`:
                     - `answer = 59 + 48 = 107` (추출한 값을 answer에 더함).
                   - `number /= 100`:
                     - `number = 48 / 100 = 0` (정수 나눗셈으로 소수점 이하 제거, number는 0이 됨).

                4. 반복 종료:
                   - `number = 0`이므로 루프 종료.

                5. 최종 출력:
                   - `answer = 107` (4859의 모든 두 자리 합).
            */
        }

        System.out.println(answer);
    }
}
