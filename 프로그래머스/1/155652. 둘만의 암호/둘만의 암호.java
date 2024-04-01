import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        
        // 알파벳 - 인덱스
        Map<Character, Integer> table = new HashMap<>();
        
        List<String> skipCharacters = Arrays.stream(skip.split(""))
            .collect(Collectors.toList());
        
        char[] idxToAlpha = new char[('z'-'a' + 1) - skip.length()];
        int runner = 0;
        for(char i = 'a'; i <= 'z'; i++){
            if(skipCharacters.contains(String.valueOf(i))){
                continue;
            }
            idxToAlpha[runner] = i;
            table.put(i, runner++);
        }
        
        int idxSize = idxToAlpha.length;
        char[] input = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++){
            int idx = table.get(input[i]);
            int convertedIdx = (idx + index) % idxSize;
            sb.append(idxToAlpha[convertedIdx]);
        }
        return sb.toString();
    }
}