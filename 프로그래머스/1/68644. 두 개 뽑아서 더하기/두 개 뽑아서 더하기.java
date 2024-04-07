import java.util.*;
import java.util.stream.*;

class Solution {
    
    static Set<Integer> s = new HashSet<>();
    
    static int[] idxs = new int[2];
    
    static boolean[] visited;
    
    public int[] solution(int[] numbers) {
        visited = new boolean[numbers.length];
        backtracking(numbers, 0, 0);
        return s.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
    
    public static void backtracking(int[] numbers, int depth, int startIdx){
        if(depth == 2){
            s.add(numbers[idxs[0]] + numbers[idxs[1]]);
            return;
        }
        
        for(int i = startIdx; i < numbers.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            idxs[depth] = i;
            backtracking(numbers, depth + 1, i);
            visited[i] = false;
        }
    }
}