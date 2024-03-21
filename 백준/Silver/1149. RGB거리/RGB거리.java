import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] p = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
            p[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][3];
        dp[1][0] = p[1][0];
        dp[1][1] = p[1][1];
        dp[1][2] = p[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + p[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + p[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + p[i][2];
        }

        int min = 999999999;
        for (int i = 0; i < 3; i++) {
            if (min > dp[N][i]) {
                min = dp[N][i];
            }
        }
        System.out.println(min);
    }
}