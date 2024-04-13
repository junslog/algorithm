import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum  = 0;
        int scoreLen = score.length;
        Arrays.sort(score);
        int idx = scoreLen - m;
        while(true){
            scoreLen -= m;
            if(scoreLen < 0){
                break;
            }
            sum += (score[idx] * m);
            idx -= m;
        }
        return sum;        
    }
}