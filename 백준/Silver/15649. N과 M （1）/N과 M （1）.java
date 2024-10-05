import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static boolean[] visited;
  static int[] values;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    values = new int[N];
    backtracking(0);
    System.out.println(sb);
    br.close();
  }

  private static void backtracking(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(values[i]).append(" ");
      }
      sb.append("\n");
    }

    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      values[depth] = i;
      backtracking(depth + 1);
      visited[i] = false;
    }
  }
}