import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] input;
    static int N;
    static int[] operator;
    static boolean[] visited;
    static int[] order;

    static int max = -2000000000;
    static int min = 2000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        operator = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        // 0 - "+" , 1 - "-", 2 - "*", 3 - '/'
        int cumulative = 0;
        for (int i = 0; i < 4; i++) {
            int currOpCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < currOpCount; j++) {
                operator[cumulative + j] = i;
            }
            cumulative += currOpCount;
        }
        visited = new boolean[N - 1];
        order = new int[N - 1];
        backtracking(0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int depth) {
        if (depth == N - 1) {
            updateMinAndMax();
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order[depth] = i;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }

    public static void updateMinAndMax() {
        int calculateResult = calculate();
        max = Math.max(calculateResult, max);
        min = Math.min(calculateResult, min);
    }

    public static int calculate() {
        int first = input[0];
        for (int i = 0; i < N - 1; i++) {
            // 0 - "+" , 1 - "-", 2 - "*", 3 - '/'
            int currOp = operator[order[i]];
            int second = input[i + 1];
            if (currOp == 0) {
                first = first + second;
            } else if (currOp == 1) {
                first = first - second;
            } else if (currOp == 2) {
                first = first * second;
            } else if (currOp == 3) {
                first = first / second;
            }
        }
        return first;
    }
}