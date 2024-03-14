import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        // for 문을 돌면서 경우의 수에 해당하는 금액의 최댓값으로 dp 설정
        int[][] dp = new int[N + 1][N + 1];
        dp[1][1] = p[1];
        if (N == 1) {
            System.out.println(p[1]);
        } else {
            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    int loopRange = Math.min(i - j, j);
                    int max = p[j] + dp[i - j][1];
                    for (int k = 1; k <= loopRange; k++) {
                        int value = p[j] + dp[i - j][k];
                        if (max < value) {
                            max = value;
                        }
                    }
                    dp[i][j] = max;
                }
            }
        }
        int maxValue = -1;
        for (int i = 1; i <= N; i++) {
            if (maxValue < dp[N][i]) {
                maxValue = dp[N][i];
            }
        }
        System.out.println(maxValue);
    }
}