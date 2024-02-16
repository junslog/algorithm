import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[][] S;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int inputIdx = 0;
        S = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                S[i][j] = input[inputIdx++];
            }
        }
        items = new int[N];
        backtracking(0);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(items[i]).append(" ");
            }
            System.out.println(sb);
            System.exit(0);
        }

        String op = S[depth][depth];
        if (op.equals("+")) {
            for (int i = 11; i <= 20; i++) {
                items[depth] = i - 10;
                if (isValid(depth)) {
                    backtracking(depth + 1);
                }
            }
        } else if (op.equals("-")) {
            for (int i = 0; i < 10; i++) {
                items[depth] = i - 10;
                if (isValid(depth)) {
                    backtracking(depth + 1);
                }
            }

        } else if (op.equals("0")) {
            items[depth] = 0;
            if (isValid(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    public static boolean isValid(int depth) {
        int sum = 0;
        for (int i = 0; i <= depth; i++) {
            for (int j = i; j <= depth; j++) {
                sum = partialSum(i, j);
                if (!getOp(sum).equals(S[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int partialSum(int i, int j) {
        int sum = 0;
        for (int index = i; index <= j; index++) {
            sum += items[index];
        }
        return sum;
    }

    public static String getOp(int sum) {
        if (sum > 0) {
            return "+";
        } else if (sum < 0) {
            return "-";
        }
        return "0";
    }
}