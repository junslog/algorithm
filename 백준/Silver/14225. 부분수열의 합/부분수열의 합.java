import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] sequence;
    static boolean[] pick;
    static boolean[] check = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        pick = new boolean[N];
        backtracking(0);
        int answer = 0;
        for (int i = 1; i <= 2000000; i++) {
            if (!check[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void backtracking(int depth) {
        if (depth == sequence.length) {
            int sum = 0;
            for (int i = 0; i < sequence.length; i++) {
                if (pick[i]) {
                    sum += sequence[i];
                }
            }
            check[sum] = true;
            return;
        }

        backtracking(depth + 1);
        pick[depth] = true;
        backtracking(depth + 1);
        pick[depth] = false;
    }
}