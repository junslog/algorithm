import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tCaseNum = Integer.parseInt(br.readLine());
        String[] tCases = new String[tCaseNum];

        for(int i = 0; i < tCaseNum; i++){
            tCases[i] = br.readLine();
        }

        int tCaseIdx = 0;
        Stack<String> parenthesisStack = new Stack<>();
        while( tCaseNum-- > 0 ){
            String[] elements = tCases[tCaseIdx].split("");
            int lParenthesisNum = 0, rParenthesisNum = 0;

            for(String e : elements){
                if(e.equals("(")) {
                    parenthesisStack.push("_");
                    lParenthesisNum++;
                }
                else if(e.equals(")")) {
                    if (!parenthesisStack.isEmpty())
                        parenthesisStack.pop();
                    rParenthesisNum++;
                }
            }

            if (lParenthesisNum == rParenthesisNum && parenthesisStack.isEmpty())
                bw.write("YES \n");
            else
                bw.write("NO \n");

            tCaseIdx++;
            parenthesisStack.clear();
        }
        bw.flush();
    }
}