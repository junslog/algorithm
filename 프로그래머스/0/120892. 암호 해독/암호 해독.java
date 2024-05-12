class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        int runner = 0;
        for(char c : cipher.toCharArray()){
            if((++runner) % code == 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}