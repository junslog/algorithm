import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == '.') {
                break;
            }
            int inputLen = input.length;
            boolean isValid = true;
            for (int i = 0; i < inputLen; i++) {
                if (input[i] == '(' || input[i] == '[') {
                    s.push(input[i]);
                }
                if (input[i] == ')' || input[i] == ']') {
                    if (s.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (input[i] == ')') {
                        if (s.pop() != '(') {
                            isValid = false;
                            break;
                        }
                    }
                    if (input[i] == ']') {
                        if (s.pop() != '[') {
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            if (!s.isEmpty()) {
                isValid = false;
            }
            if (isValid) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
            s.clear();
        }
        System.out.println(sb);
    }
}