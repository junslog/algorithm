import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] matrix;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    long[][] dp = new long[N][N];
    dp[0][0] = 1L;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == N - 1 && j == N - 1) {
          break;
        }
        if (i + matrix[i][j] < N) {
          dp[i + matrix[i][j]][j] += dp[i][j];
        }
        if (j + matrix[i][j] < N) {
          dp[i][j + matrix[i][j]] += dp[i][j];
        }
      }
    }
    System.out.println(dp[N - 1][N - 1]);
  }
}