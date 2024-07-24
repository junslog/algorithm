import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        if(num_list.length <= 10){
            return Arrays.stream(num_list).
                reduce((a,b) -> a*b)
                .getAsInt();
        } else {
            return Arrays.stream(num_list).sum();
        }
    }
}