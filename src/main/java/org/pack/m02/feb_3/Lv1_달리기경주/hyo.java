package org.pack.m02.feb_3.Lv1_달리기경주;

public class hyo {
    public String[] solution(String[] players, String[] callings) {
        for(String calling : callings){
            for(int i=0; i<players.length; i++){
                if(players[i].equals(calling)){
                    String temp = players[i-1];
                    players[i-1] = players[i];
                    players[i] = temp;
                    break;
                }
            }
        }
        return players;
    }
}
