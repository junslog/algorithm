import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N + 1][3];

        dp[1][0] = 0;
        dp[1][1] = p[1];
        dp[1][2] = 0;
        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                dp[i][1] = dp[i - 1][0] + p[i];
                dp[i][2] = dp[i - 1][1] + p[i];
            }

            int max = dp[1][1];
            for (int i = N - 2; i <= N; i++) {
                if (max < dp[i][1]) {
                    max = dp[i][1];
                }
                if (max < dp[i][2]) {
                    max = dp[i][2];
                }
            }
            System.out.println(max);
        } else {
            System.out.println(p[1]);
        }
    }
}