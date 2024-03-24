import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1. 점화식 설정
        // dp[n][0] : 이전 것 중 하나를 제거하지 않은 상태의 최댓값
        // dp[n][1] : 이전 것 중 하나를 제거한 상태의 최댓값
        // dp[n][0] = max( dp[N-1][0] + arr[n], arr[n] )
        // dp[n][1] = max( dp[N-2][0], dp[N-1][1] ) + arr[n]
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int answer = arr[0];
        if (n >= 2) {
            dp[1][0] = Math.max(dp[0][0] + arr[1], arr[1]);
            dp[1][1] = Math.max(arr[0], arr[1]);
            answer = Math.max(dp[1][0], dp[1][1]);
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 1][1]) + arr[i];
                if (answer < dp[i][0]) {
                    answer = dp[i][0];
                }
                if (answer < dp[i][1]) {
                    answer = dp[i][1];
                }
            }
        }
        System.out.println(answer);
    }
}