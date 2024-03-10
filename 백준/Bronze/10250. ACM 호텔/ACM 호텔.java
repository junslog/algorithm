import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int first, second;
            if (N % H == 0) {
                first = H;
                second = N / H;
            } else {
                first = N % H;
                second = (N / H) + 1;
            }
            if (second < 10) {
                sb.append(first).append(0).append(second).append("\n");
            } else {
                sb.append(first).append(second).append("\n");
            }
        }
        System.out.println(sb);
    }
}