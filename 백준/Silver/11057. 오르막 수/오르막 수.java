import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1. 점화식 설정
        // D[N] => N자리의 오르막 수의 개수
        // D[N][K] => N자리의 오르막 수 중 끝 자리가 K ( 1 <= K <= 9 )로 끝나는 수의 개수
        // D[N][K] = sigma(D[N-1][K-a]) for a = 0 ... K
        int[][] dp = new int[N + 1][10];
        
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 3. Bottom-Up 방식으로 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % 10007;
        }
        System.out.println(sum);
    }
}