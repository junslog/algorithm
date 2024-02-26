import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Position> positions = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            positions.add(new Position(i, Integer.parseInt(st.nextToken())));
        }
        positions.sort((x, y) -> x.value - y.value);
        Position[] dp = new Position[N];
        dp[0] = positions.get(0);
        dp[0].compactedValue = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = positions.get(i);
            if (dp[i].value == dp[i - 1].value) {
                dp[i].compactedValue = dp[i - 1].compactedValue;
            } else {
                dp[i].compactedValue = dp[i - 1].compactedValue + 1;
            }
        }
        Arrays.sort(dp, (x, y) -> x.idx - y.idx);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            sb.append(dp[i].compactedValue).append(" ");
        }
        System.out.println(sb);
    }

    public static class Position {
        int idx;
        int value;
        int compactedValue;

        Position(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

    }
}