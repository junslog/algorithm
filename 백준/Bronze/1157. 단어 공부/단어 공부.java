import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();
        Map<Character, Integer> wordRemember = new HashMap<>();
        for(int i = 0; i < inputArr.length; i++){
            if(isBig(inputArr[i])){
                wordRemember.put(inputArr[i], wordRemember.getOrDefault(inputArr[i], 0) + 1);
            } else {
                wordRemember.put(toBig(inputArr[i]),
                        wordRemember.getOrDefault(toBig(inputArr[i]),0) + 1);
            }
        }
        int maxValue = 0;
        for(int value : wordRemember.values()){
            if(maxValue < value){
                maxValue = value;
            }
        }
        List<Character> answerList = new ArrayList<>();
        for(char key : wordRemember.keySet()){
            if(wordRemember.get(key) == maxValue){
                answerList.add(key);
            }
        }

        if(answerList.size() > 1){
            System.out.print("?");
        } else {
            System.out.print(answerList.get(0));
        }
    }

    public static boolean isBig(char ch){
        return ch - 'a' < 0;
    }

    public static char toBig(char ch){
        int a = ch + ('A' - 'a');
        return (char) a;
    }
}