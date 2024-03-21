import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // dp[K][N] : 1~N까지의 수 K개로 N을 만들 수 있는 경우의 수
        int[][] dp = new int[K + 1][N + 1];
        // 1. 초기값 설정
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }
        // 2. 점화식 D[K][N] = sigma(D[K-1][N-a]) for 0 <= a <= Nx
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = j; k >= 0; k--) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}