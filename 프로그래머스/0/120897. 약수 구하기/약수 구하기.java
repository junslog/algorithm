import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                list.add(i);
                if(i*i != n){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    
}