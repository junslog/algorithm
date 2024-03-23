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
        // dp[N] : N번째 idx의 증가하는 부분 수열 중 가장 큰 합의 값
        // dp[N] : 0 ~ N-1 번(j)까지의 input을 돌면서, arr[N] > arr[j] 일 때, max(dp[j] + arr[N], dp[N])
        // dp[N]의 초기값 = arr[N] 으로 둔다.
        int[] dp = new int[N];
        int max = input[0];
        for (int i = 0; i < N; i++) {
            dp[i] = input[i];
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + input[i]);
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
