import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] leftHigherCount;
  static int[] line;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    leftHigherCount = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      leftHigherCount[i] = Integer.parseInt(st.nextToken());
    }
    line = new int[N + 1];
    visited = new boolean[N + 1];
    backtracking(1);
  }

  private static void backtracking(int depth) {
    if (depth == N + 1) {
      if (isValid()) {
        for (int i = 1; i <= N; i++) {
          System.out.print(line[i] + " ");
        }
      }
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      line[depth] = i;
      backtracking(depth + 1);
      visited[i] = false;
    }
  }

  private static boolean isValid() {
    for (int i = 1; i <= N; i++) {
      int count = 0;
      int currHeight = line[i];
      for (int j = 1; j <= i; j++) {
        if (currHeight < line[j]) {
          count++;
        }
      }
      if (count != leftHigherCount[line[i]]) {
        return false;
      }
    }
    return true;
  }
}