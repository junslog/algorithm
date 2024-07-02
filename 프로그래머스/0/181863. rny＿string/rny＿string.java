class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        for(char c : rny_string.toCharArray()){
            if(c != 'm'){
                sb.append(c);
            } else {
                sb.append("rn");
            }
        }
        return sb.toString();
    }
}