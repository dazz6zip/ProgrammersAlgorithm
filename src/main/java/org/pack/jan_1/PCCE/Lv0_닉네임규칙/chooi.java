package org.pack.jan_1.PCCE.Lv0_닉네임규칙;

public class chooi {
    public String solution(String nickname){
        String answer = "";
        for(int i = 0; i < nickname.length(); i++){
            // charAt : 문자열에서 특정 위치에 있는 문자를 가져오는 메소드
            // 해당 코드에서는 문자열을 한 글자씩 탐색하며 'l' 문자를 찾고, 이를 "I"로 변환하여 answer에 추가하는 역할을 함
            if(nickname.charAt(i)  == 'l'){
                answer += "I";
            }else if(nickname.charAt(i) == 'w'){
                answer += "vv";
            }else if(nickname.charAt(i) == 'O'){
                answer += "0";
            } else {
                answer += nickname.charAt(i);
            }
        }

        while(answer.length() < 4){
            answer += "o";
        }
        if(answer.length() > 8) {
            answer = answer.substring(0, 8);
        }

        return answer;
    }
}
