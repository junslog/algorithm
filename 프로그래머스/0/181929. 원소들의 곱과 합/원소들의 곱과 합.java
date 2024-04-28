import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        long cumulativePow = num_list[0];
        for(int i = 1; i < num_list.length; i++){
            cumulativePow *= num_list[i];
        }
        int sum = Arrays.stream(num_list).sum();
        return (sum * sum) > cumulativePow ? 1 : 0;
    }
}