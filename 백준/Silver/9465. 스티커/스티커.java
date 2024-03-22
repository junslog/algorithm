import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // S[N][1] = Max(S[N-2][1] + P[N-1][2], S[N-2][2]) + P[N][1]
        // S[N][2] = Max(S[N-2][2] + P[N-1][1], S[N-2][1]) + P[N][2]

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] p = new int[N + 1][3];
            int[][] s = new int[N + 1][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                p[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                p[i][2] = Integer.parseInt(st.nextToken());
            }
            s[1][1] = p[1][1];
            s[1][2] = p[1][2];
            if (N >= 2) {
                s[2][1] = p[1][2] + p[2][1];
                s[2][2] = p[1][1] + p[2][2];
            }
            for (int i = 3; i <= N; i++) {
                s[i][1] = Math.max(s[i - 1][2], s[i - 2][2]) + p[i][1];
                s[i][2] = Math.max(s[i - 1][1], s[i - 2][1]) + p[i][2];
            }
            sb.append(Math.max(s[N][1], s[N][2])).append("\n");
        }
        System.out.println(sb);
    }
}