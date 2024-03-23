import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 점화식, 초기값 설정
        // D[N][K] = max( D[N-1][K-1], D[N-1][K] ) + E[N][K]
        // D[N][0] = sigma(D[K][0]) for 0 <= k <= N
        // D[N][N] = sigma(D[K][K]) for 0 <= k <= N
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][0] += triangle[j][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][i] += triangle[j][j];
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[n - 1][i]) {
                max = dp[n - 1][i];
            }
        }
        System.out.println(max);
    }
}