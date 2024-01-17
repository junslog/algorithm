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

        int T = Integer.parseInt(br.readLine());
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < T; i++){
            String inputLine = br.readLine();
            char[] inputChars = inputLine.toCharArray();
            int inputLength = inputChars.length;
            int runner = 0;
            while(inputLength-- > 0){
                if(inputChars[runner] != ' ' && inputLength != 0){
                    s.push(inputChars[runner]);
                } else {
                    if(inputLength == 0){
                        s.push(inputChars[runner]);
                    }
                    while(!s.isEmpty()) {
                        bw.append(s.pop());
                    }
                    bw.append(' ');
                }
                runner++;
            }
            bw.append('\n');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}