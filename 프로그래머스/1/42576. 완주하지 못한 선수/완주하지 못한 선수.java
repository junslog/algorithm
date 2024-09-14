import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pMap = new HashMap<>();
        for(String p : participant){
            pMap.put(p, pMap.getOrDefault(p, 0) + 1);
        }
        Map<String, Integer> cMap = new HashMap<>();
        for(String c : completion){
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }
        String answer = "";
        for(String pKey : pMap.keySet()){
            int pCount = pMap.get(pKey);
            int cCount = cMap.getOrDefault(pKey, -1);
            if(cCount == - 1 || pCount > cCount){
                answer = pKey;
                break;
            }
        }
        return answer;
    }
}