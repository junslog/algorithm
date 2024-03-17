import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[91][2];
        d[1][0] = 0;
        d[1][1] = 1;
        d[2][0] = 1;
        d[2][1] = 0;
        d[3][0] = 1;
        d[3][1] = 1;
        for (int i = 4; i <= 90; i++) {
            d[i][0] = d[i - 1][1] + d[i - 1][0];
            d[i][1] = d[i - 1][0];
        }
        System.out.println(d[N][0] + d[N][1]);
    }
}
