import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length -1; i >= 0; i--){
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.toString());
    }
}