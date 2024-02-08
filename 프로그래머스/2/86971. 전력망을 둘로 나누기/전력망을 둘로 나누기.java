import java.util.*;

class Solution {
    static int wireLength;
    static int totalPowers;
    static int minimumDiff;
    static int[][] wire;
    
    public int solution(int n, int[][] wires) {
        totalPowers = n;
        minimumDiff = n;
        wire = wires;
        wireLength = wire.length;
        getMinimumDiff();
        return minimumDiff;
    }
    
    public static void getMinimumDiff(){
        for(int i = 0; i < wireLength; i++){
            dfs(i);
        }
    }
    
    public static void dfs(int checkIdx){
        Set<Integer> powers = new HashSet<>();
        List<Integer> checkIdxs = new ArrayList<>();
        checkIdxs.add(checkIdx);
        powers.add(wire[checkIdx][0]);
        for(int j = 0; j < wireLength; j++){
            for(int i = 0; i < wireLength; i++){
                if(checkIdxs.contains(i)){
                    continue;
                }
                if(powers.contains(wire[i][0]) || powers.contains(wire[i][1])){
                    powers.add(wire[i][0]);
                    powers.add(wire[i][1]);
                    checkIdxs.add(i);
                }
            }
        }
    
        int diff = Math.abs(totalPowers - 2*powers.size());
        if(diff < minimumDiff){
            minimumDiff = diff;
        }
    }
}