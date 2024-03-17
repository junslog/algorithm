import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // p[k][n] = p[k-1][1] + p[k-1][2] + p[k-1][3] ... + p[k-1][n]
        int[][] p = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            p[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                for (int k = 1; k <= j; k++) {
                    p[i][j] += p[i - 1][k];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(p[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}