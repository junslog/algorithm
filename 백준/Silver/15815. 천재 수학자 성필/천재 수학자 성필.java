import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> operands = new Stack<>();
        List<Character> operators = new ArrayList<>(Arrays.asList('*', '+', '-', '/'));

        char[] inputs = br.readLine().toCharArray();

        for (char input : inputs) {
            if (!operators.contains(input)) {
                operands.push(Integer.valueOf(String.valueOf(input)));
            } else {
                int last = operands.pop();
                int first = operands.pop();
                operands.push(applyOperation(first, last, input));
            }
        }
        System.out.print(operands.pop());
        br.close();
    }

    public static int applyOperation(int A, int B, char operator) {
        if (operator == '+') {
            return A + B;
        }
        if (operator == '-') {
            return A - B;
        }
        if (operator == '*') {
            return A * B;
        }
        if (operator == '/') {
            return A / B;
        }
        throw new RuntimeException("Not applicable Operation");
    }
}