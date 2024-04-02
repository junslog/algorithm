import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer = Arrays.stream(String.valueOf(n).split(""))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
        
        Collections.reverse(answer);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}