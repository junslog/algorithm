import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Map<Integer, Integer> citationToNumber = new HashMap<>();
        int citationLen = citations.length;
        for(int i = 0; i < citationLen; i++){
            if(citations[i] >= 1000){
                citationToNumber.put(1000, 
                                     citationToNumber.getOrDefault(1000, 0) + 1);
                continue;
            }
            citationToNumber
                .put(citations[i],
                     citationToNumber.getOrDefault(citations[i], 0) + 1);
        }
        
        int cumulativeNumOfCitations = 0;
        int hIndex = 0;
        for(int i = 1000; i >= 0; i--){
            cumulativeNumOfCitations += citationToNumber.getOrDefault(i, 0);
            if(i <= cumulativeNumOfCitations){
                hIndex = i;
                break;
            }
        }
        return hIndex;
    }
}