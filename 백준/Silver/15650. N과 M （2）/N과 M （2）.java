import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] items;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        items = new int[M];
        combination(0, 1);
        System.out.println(sb);
        br.close();
    }

    public static void combination(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            items[depth] = i;
            combination(depth + 1, i + 1);
            check[i] = false;
        }
    }
}