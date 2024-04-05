import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] input;
    static int[] operator = new int[4];
    static int[] selectedOp = new int[4];
    static int[] opStatus;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        opStatus = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int depth) {
        if (selectedOp[0] > operator[0] ||
                selectedOp[1] > operator[1] ||
                selectedOp[2] > operator[2] ||
                selectedOp[3] > operator[3]) {
            return;
        }

        if (depth == N - 1) {
            int sum = calculate();
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        selectedOp[0] += 1;
        opStatus[depth] = 0;
        backtracking(depth + 1);
        selectedOp[0] -= 1;

        selectedOp[1] += 1;
        opStatus[depth] = 1;
        backtracking(depth + 1);
        selectedOp[1] -= 1;

        selectedOp[2] += 1;
        opStatus[depth] = 2;
        backtracking(depth + 1);
        selectedOp[2] -= 1;

        selectedOp[3] += 1;
        opStatus[depth] = 3;
        backtracking(depth + 1);
        selectedOp[3] -= 1;
    }

    public static int calculate() {
        int first = input[0];
        for (int i = 0; i < input.length - 1; i++) {
            int second = input[i + 1];
            if (opStatus[i] == 0) {
                first += second;
            } else if (opStatus[i] == 1) {
                first -= second;
            } else if (opStatus[i] == 2) {
                first *= second;
            } else if (opStatus[i] == 3) {
                first /= second;
            }
        }
        return first;
    }
}