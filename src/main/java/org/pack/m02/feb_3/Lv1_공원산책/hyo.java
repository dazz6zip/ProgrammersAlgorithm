package org.pack.m02.feb_3.Lv1_공원산책;

public class hyo {
    public int[] solution(String[] park, String[] routes) {
        int rowS = findS(park)[0];
        int colS = findS(park)[1];
        
        for(String route:routes){
            String direction = route.split(" ")[0];
            int cnt =  Integer.parseInt(route.split(" ")[1]);
            int rowImsi = rowS;
            int colImsi = colS;
            boolean isPossible = true;
            for(int i=0; i<cnt; i++){
                int[] imsi = move(direction, rowImsi, colImsi);
                rowImsi = imsi[0];
                colImsi = imsi[1];
                if(rowImsi < 0 || rowImsi >= park.length || colImsi < 0 || colImsi >= park[0].length() || park[rowImsi].charAt(colImsi) == 'X') {
                    isPossible = false; 
                    break;
                }
            }
            if(isPossible){
                rowS = rowImsi;
                colS = colImsi;
            }
        }

        return new int[]{rowS, colS};
    }
    
    public static int[] findS(String[] park) {
        for (int row = 0; row < park.length; row++) {
            int col = park[row].indexOf("S");
            if (col != -1) return new int[]{row, col};
        }
        return new int[]{-1, -1};
    }
        
    public static int[] move(String route, int rowS, int colS) {
    switch (route) {
        case "E": colS++; break;
        case "W": colS--; break;
        case "S": rowS++; break;
        case "N": rowS--; break;
        default: break;
    }
    return new int[]{rowS, colS};
    }
}
