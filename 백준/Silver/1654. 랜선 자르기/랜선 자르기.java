import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lans = new long[K];
        for (int i = 0; i < K; i++) {
            lans[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lans); // O(N^2) 까지 갈 수 있음.
        long max = 0;
        long from = 1;
        long to = lans[lans.length - 1];
        // Binary Search
        while (true) {
            long mid = (from + to) / 2;
            if (to == from) {
                max = from;
                break;
            }
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += lans[i] / mid;
            }
            if (sum >= N) {
                from = mid;
            } else {
                to = mid;
            }

            if (to - from == 1) {
                long sum2 = 0;
                for (int i = 0; i < K; i++) {
                    sum2 += lans[i] / to;
                }
                if (sum2 >= N) {
                    max = to;
                } else {
                    max = from;
                }
                break;
            }
        }
        System.out.println(max);
    }
}