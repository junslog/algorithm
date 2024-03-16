import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];
        // dp[a][b] => a 자리 수인 계단수 중 숫자 b로 끝나는 수의 개수
        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            dp[i][9] = dp[i - 1][8] % 1000000000;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (((dp[i - 1][j - 1]) % 1000000000 + (dp[i - 1][j + 1]) % 1000000000)) % 1000000000;
            }
        }
        long nStairNum = 0;
        for (int i = 0; i <= 9; i++) {
            nStairNum = (nStairNum + dp[N][i]) % 1000000000;
        }
        System.out.println(nStairNum);
    }
}