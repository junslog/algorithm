class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(char c : n_str.toCharArray()){
            if(c == '0' && !found){
                continue;
            }
            found = true;
            sb.append(c);
        }
        return sb.toString();
    }
}