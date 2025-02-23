package org.pack.feb_4.Lv1_택배상자꺼내기;

public class hyo {
    public int solution(int n, int w, int num) {
        int row_num = (num-1) / w;
        int col_num = (row_num % 2 == 0) ? (num-1) % w : w-1 - ((num-1) % w);
        int row_N = (n-1) / w;
 
        int answer = 0;
        int[][] box = new int[row_N + 1][w];
        int cnt = 1;
        
        for(int i=0; i< row_N + 1; i++){
            for(int j=0; j<w; j++){ 
                if(i%2==0) box[i][j] = cnt;
                else box[i][w-j-1] = cnt;
                cnt++;
                if(cnt > n) break;
            }
        }
 
        answer = row_N - row_num + 1;
        if(box[row_N][col_num] == 0){
            answer -= 1;
        }
 
        return answer;
     }
}

