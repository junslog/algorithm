class Solution {
    public int solution(String t, String p) {
        int pLen = p.length();
        char pStart = p.charAt(0);
        long pVal = Long.parseLong(p);
        
        int tLen = t.length();
        int answer = 0;
        for(int i = 0; i <= tLen - pLen; i++){
            if(t.charAt(i) - pStart > 0){
                continue;
            }
            long tSubVal = Long.parseLong(t.substring(i, i + pLen));
            if(pVal >= tSubVal){
                answer++;
            }
        }
        return answer;
    }
}