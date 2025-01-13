package org.pack.jan_1.PCCE.Lv0_닉네임규칙;

public class dazz6 {
    public static void main(String[] args) {
        dazz6 dazz6 = new dazz6();
        System.out.println(dazz6.solution("WORLDworld"));
        System.out.println(dazz6.solution("GO"));
    }
    public String solution(String nickname) {
        String answer = "";
        for(int i=0; i<nickname.length(); i++){
            if(nickname.charAt(i) == 'l'){
                answer += "I";
            }
            else if(nickname.charAt(i) == 'w'){
                answer += "vv";
            }
            else if(nickname.charAt(i) == 'W'){
                answer += "VV";
            }
            else if(nickname.charAt(i) == 'O'){
                answer += "0";
            }
            else{
                answer += nickname.charAt(i);
            }
        }
        for(int i = 0 ; answer.length() < 4 ; i++){
            answer += "o";
        }
        if(answer.length() > 8){
            answer = answer.substring(0, 8);
        }
        return answer;
    }
}
