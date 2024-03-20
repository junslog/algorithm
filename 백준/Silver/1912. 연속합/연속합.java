import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = input[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
        }
        int maxVal = -999999999;
        for (int i = 0; i < n; i++) {
            if (maxVal < dp[i]) {
                maxVal = dp[i];
            }
        }
        System.out.println(maxVal);
    }
}