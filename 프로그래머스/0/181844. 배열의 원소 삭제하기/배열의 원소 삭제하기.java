import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = Arrays.stream(delete_list)
            .boxed()
            .collect(Collectors.toSet());

        List<Integer> result = new ArrayList<>();
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                result.add(num);
            }
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}