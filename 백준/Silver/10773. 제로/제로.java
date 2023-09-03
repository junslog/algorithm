import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int counter = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        int inputNum;
        while( counter -- > 0 ){
            inputNum = Integer.parseInt(br.readLine());
            if(inputNum != 0)
                s.push(inputNum);
            else
                s.pop();
        }
        bw.write("" + s.stream().mapToInt(Integer::intValue).sum());
        bw.close();
    }
}