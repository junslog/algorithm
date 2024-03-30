import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] realLost = new boolean[n + 1];
        boolean[] canLend = new boolean[n + 2];
        
        List<Integer> lostStudent = new ArrayList<>();
        int lLen = lost.length;
        for(int i = 0; i < lLen; i++){
            lostStudent.add(lost[i]);
        }
        
        List<Integer> reserveStudent = new ArrayList<>();
        int rLen = reserve.length;
        for(int i = 0; i < rLen; i++){
            reserveStudent.add(reserve[i]);
        }
        
        for(int rs : reserveStudent){
            canLend[rs] = true;
        }
        for(int ls : lostStudent){
            realLost[ls] = true;
            if(reserveStudent.contains(ls)){
                realLost[ls] = false;
                canLend[ls] = false;
            }
        }

        for(int i = 1; i <= n; i++){
            if(realLost[i] && canLend[i-1]){
                canLend[i-1] = false;
                realLost[i] = false;
            }
            if(realLost[i] && canLend[i+1]){
                canLend[i+1] = false;
                realLost[i] = false;
            }
        }
     
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(!realLost[i]){
                answer++;
            }
        }
        return answer;
    }
}