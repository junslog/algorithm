class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(('l' - Character.toLowerCase(c))  > 0){
                sb.append('l');
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}