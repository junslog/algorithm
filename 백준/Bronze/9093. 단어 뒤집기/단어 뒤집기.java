import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String inputLine;
        Stack<String> s = new Stack<>();

        for(int i = 0; i < T; i++){
            inputLine = br.readLine();
            List<String> strings = Arrays.stream(inputLine.split(" ")).collect(Collectors.toList());
            for(int j = 0; j < strings.size(); j++){
                String[] strs = strings.get(j).split("");
                for(int k = 0; k < strs.length; k++){
                    s.push(strs[k]);
                }
                int stackSize = s.size();
                for(int l = 0; l < stackSize; l++){
                    bw.append(s.pop());
                }
                bw.append(" ");
            }
            bw.append('\n');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}