class Solution {
    public int solution(String before, String after) { 
        int[] a = new int['z'-'a'+1];
        for(char c : before.toCharArray()){
            a['z'- c]++;
        }
        
        int[] b = new int['z'-'a'+1];
        for(char c : after.toCharArray()){
            b['z'- c]++;
        }
        
        for(char c = 'z'; c >= 'a'; c = (char) (c - 1)){
            if(a['z'-c] != b['z'-c]){
                return 0;
            }
        }
        return 1;
    }
}