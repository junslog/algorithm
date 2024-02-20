import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        int[] cumulativeSum = new int[N];
        cumulativeSum[0] = P[0];
        for (int i = 1; i < N; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + P[i];
        }
        int sum = 0;
        for (int cS : cumulativeSum) {
            sum += cS;
        }
        System.out.println(sum);
    }
}