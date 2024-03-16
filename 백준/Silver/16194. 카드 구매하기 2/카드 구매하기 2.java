import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[1001];
        d[1] = p[1];
        for (int i = 2; i <= N; i++) {
            int cumulativeMin = 999999999;
            for (int j = 1; j < i; j++) {
                int curr = d[i - j] + p[j];
                if (cumulativeMin >= curr) {
                    cumulativeMin = curr;
                }
            }
            d[i] = Math.min(cumulativeMin, p[i]);
        }
        System.out.println(d[N]);
    }
}