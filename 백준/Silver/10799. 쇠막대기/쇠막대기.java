import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] inputArr = br.readLine().toCharArray();

        int inputSize = inputArr.length;
        int idxRunner = 0;
        char currInput;
        Stack<Character> s = new Stack<>();
        int numOfSlices = 0;

        while(inputSize-- > 0){
            currInput = inputArr[idxRunner++];
            // 마지막
            if(currInput == ')' && idxRunner == inputArr.length){
                break;
            }
            if(currInput == '(' && inputArr[idxRunner] == ')'){
                // 레이저인 경우
                numOfSlices += s.size();
                if(idxRunner == inputArr.length - 1){
                    break;
                }
                idxRunner++;
            } else if(currInput == '(' && inputArr[idxRunner] == '(') {
                // 막대기 시작 부분인 경우
                s.push('(');
                numOfSlices++;
            } else if(currInput == ')' && inputArr[idxRunner - 1] == ')'){
                // 막대기 끝 부분인 경우
                s.pop();
            }
        }
        bw.append(String.valueOf(numOfSlices));
        bw.flush();
        br.close();
    }
}