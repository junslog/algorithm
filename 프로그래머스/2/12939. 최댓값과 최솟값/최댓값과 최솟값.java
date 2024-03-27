import java.util.StringTokenizer;
import java.util.NoSuchElementException;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        long max = Long.parseLong(st.nextToken());
        long min = max;
        String ss;
        while(true){
            try{
                ss = st.nextToken();
                long input = Long.parseLong(ss);
                if(input > max){
                    max = input;
                }
                if(input < min){
                    min = input;
                }
            }catch (NoSuchElementException ex){
                break;
            }
        }
        return min + " " + max;
    }
}