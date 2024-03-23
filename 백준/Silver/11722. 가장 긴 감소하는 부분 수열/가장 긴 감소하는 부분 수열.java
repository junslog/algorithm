import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int maxLen = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] < input[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (maxLen < dp[i]) {
                        maxLen = dp[i];
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}