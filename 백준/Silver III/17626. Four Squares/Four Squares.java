import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[50001];
        // Bottom-Up
        dp[1] = 1;
        dp[2] = 2;
        find(N);
        System.out.println(dp[N]);
    }

    public static void find(int N) {
        for (int i = 3; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
    }
}