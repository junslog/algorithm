import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(""))
            .sorted(Collections.reverseOrder())
            .forEach(st -> sb.append(st));
        return sb.toString();
    }
}