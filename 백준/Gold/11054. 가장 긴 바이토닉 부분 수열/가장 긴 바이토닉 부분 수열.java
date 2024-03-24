import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 점화식 설정
        // dp[N][0] : N번째 인덱스 까지의 부분 수열 중 증가하고 있는 부분 수열의 최대 길이
        // dp[N][1] : N번째 인덱스 까지의 부분 수열 중 감소 or 증가하다 감소하는 부분 수열의 최대 길이
        // dp[N][0] : if arr[N] > arr[j], dp[N][0] = max(dp[N][0], dp[j][0] + 1 )
        // dp[N][1] : if arr[N] < arr[j], dp[N][1] = max(dp[N][1], dp[N][0] + 1, dp[N][1] + 1)
        // dp[0][0] = 1, dp[0][1] = 1
        int[][] dp = new int[N][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int maxLen = 1;
        for (int i = 1; i < N; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (s[i] > s[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
                if (s[i] < s[j]) {
                    dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0] + 1, dp[j][1] + 1));
                }
                if (dp[i][0] > maxLen) {
                    maxLen = dp[i][0];
                }
                if (dp[i][1] > maxLen) {
                    maxLen = dp[i][1];
                }
            }
        }
        System.out.println(maxLen);
    }
}