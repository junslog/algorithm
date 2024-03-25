class Solution {
    public String solution(String[] seoul) {
        int sLen = seoul.length;
        for(int i = 0; i < sLen; i++){
            if(seoul[i].equals("Kim")){
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }
}