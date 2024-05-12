import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n) {
        Set<Integer> yakSu = new HashSet<>();
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0){
                yakSu.add(i);
                yakSu.add(n/i);
            }
        }
        return yakSu.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}