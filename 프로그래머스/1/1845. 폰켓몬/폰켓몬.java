import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> pkm = new HashMap<>();
        for(int i : nums){
            pkm.put(i, pkm.getOrDefault(i, 0) + 1);
        }
        int N = nums.length;
        int canChooseCount = N / 2;
        return Math.min(canChooseCount, pkm.keySet().size());
    }
}