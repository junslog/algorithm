class Solution {
    boolean solution(String s) {
        char[] values = new char[s.length()];
        int runner = 0;
        for(char c : s.toCharArray()){
            values[runner++] = Character.toLowerCase(c);
        }
        int pCount = 0, yCount = 0;
        for(char c : values){
            if(c == 'p'){
                pCount++;
            } else if(c == 'y'){
                yCount++;
            }
        }
        return pCount == yCount;
    }
}