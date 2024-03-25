import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tSizeToCount = new HashMap<>();
        int tSize = tangerine.length;
        for(int i = 0; i < tSize; i++){
            tSizeToCount.put(tangerine[i], tSizeToCount.getOrDefault(tangerine[i], 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>();
        for(int key : tSizeToCount.keySet()){
            pq.add(tSizeToCount.get(key));
        }
        int remain = tSize - k;
        int allVarietyCount = tSizeToCount.keySet().size();
        while(remain > 0){
            int r = pq.poll();
            remain -= r;
            if(remain < 0){
                break;
            }
            allVarietyCount--;
        }
        return allVarietyCount;
    }
}