class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        char v = alp.toCharArray()[0];
        for(char c : my_string.toCharArray()){
            if(c == v){
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}