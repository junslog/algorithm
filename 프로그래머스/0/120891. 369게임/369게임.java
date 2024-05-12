import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int order) {
        return Arrays.stream(String.valueOf(order).split(""))
            .filter(ch -> ch.equals("3") || ch.equals("6") || ch.equals("9"))
            .collect(Collectors.toList())
            .size();
    }
}