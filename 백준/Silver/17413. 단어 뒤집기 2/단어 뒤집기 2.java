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

        char[] inputChars = (br.readLine() + '\n').toCharArray();

        Stack<Character> s = new Stack<>();
        int idxRunner = 0;
        int inputSize = inputChars.length;
        char curChar;
        boolean writeSerialMode = false;

        while(idxRunner < inputSize){
            curChar = inputChars[idxRunner++];
            if(curChar == '\n'){
                if(!writeSerialMode){
                    while(!s.isEmpty()){
                        bw.append(s.pop());
                    }
                }
                continue;
            }
            if(curChar == '<'){
                while(!s.isEmpty()){
                    bw.append(s.pop());
                }
                writeSerialMode = true;
                bw.append(curChar);
                continue;
            }
            if(curChar == '>'){
                writeSerialMode = false;
                bw.append(curChar);
                continue;
            }
            if(writeSerialMode){
                bw.append(curChar);
            }
            if(!writeSerialMode){
                if(curChar == ' '){
                    while(!s.isEmpty()){
                        bw.append(s.pop());
                    }
                    bw.append(curChar);
                } else {
                    s.push(curChar);
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}