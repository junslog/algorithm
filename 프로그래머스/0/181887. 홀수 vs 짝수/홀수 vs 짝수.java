import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int oddSum = IntStream.range(1, num_list.length + 1)
            .filter(r -> r%2 == 1)
            .map(r -> num_list[r-1])
            .sum();
        
        int evenSum = IntStream.range(1, num_list.length + 1)
            .filter(r -> r%2 == 0)
            .map(r -> num_list[r-1])
            .sum();
        
        return (oddSum > evenSum)? oddSum : evenSum;
    }
}