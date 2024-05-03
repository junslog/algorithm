class Solution {
    public String solution(int q, int r, String code) {
        char[] input = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = r; i < input.length; i += q){
            sb.append(input[i]);
        }
        return sb.toString();
    }
}