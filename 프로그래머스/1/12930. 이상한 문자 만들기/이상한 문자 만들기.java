import java.util.*;

class Solution {
    public String solution(String s) {
        char[] input = s.toCharArray();
        int runner = 0;
        char[] output = new char[input.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++){
            if(input[i] == ' '){
                output[i] = ' ';
                runner = 0;
                continue;
            }
            if(runner % 2 == 0){
                output[i] = Character.toUpperCase(input[i]); 
            } else {
                output[i] = Character.toLowerCase(input[i]);
            }
            runner++;
        }
        return new String(output);
    }
}