import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] pS = new int[N];
        st = new StringTokenizer(br.readLine());
        pS[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            pS[i] = pS[i - 1] + Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            for (int i = 0; i < M; i++) {
                System.out.println(pS[0]);
            }
        } else {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int startIdx = Integer.parseInt(st.nextToken());
                int endIdx = Integer.parseInt(st.nextToken());
                startIdx -= 2;
                endIdx -= 1;
                if (startIdx == -1) {
                    System.out.println(pS[endIdx]);
                    continue;
                }
                System.out.println(pS[endIdx] - pS[startIdx]);
            }
        }

    }
}