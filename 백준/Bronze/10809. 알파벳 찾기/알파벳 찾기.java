import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();

        int arrLen = inputArr.length;

        Map<Character, Integer> charToEnterSequence = new HashMap<>();

        for(int i = 0; i < arrLen; i++){
            char curChar = inputArr[i];
            if(!charToEnterSequence.containsKey(curChar)){
                charToEnterSequence.put(curChar, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 'a'; i <= 'z'; i++){
            if(charToEnterSequence.containsKey((char) i)){
                sb.append(charToEnterSequence.get((char) i)).append(" ");
            } else {
                sb.append(-1).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}