import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Double> operands = new Stack<>();
        List<Character> operators = new ArrayList<>(Arrays.asList('*', '+', '-', '/'));

        char[] inputs = br.readLine().toCharArray();
        Map<Character, Double> charToScore = new HashMap<>();

        for (int i = 0; i < N; i++) {
            charToScore.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }

        for (int i = 0; i < inputs.length; i++) {
            if (!operators.contains(inputs[i])) {
                operands.push(charToScore.get(inputs[i]));
            } else {
                char operator = inputs[i];
                double A = operands.pop();
                double B = operands.pop();
                operands.push(applyOperation(B, A, operator));
            }
        }
        System.out.printf("%.2f", operands.pop());
    }

    public static double applyOperation(double A, double B, char operator) {
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