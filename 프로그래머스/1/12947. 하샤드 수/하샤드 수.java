import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split(""))
            .mapToInt(Integer::parseInt)
            .sum();
        return x % sum == 0;
    }
}