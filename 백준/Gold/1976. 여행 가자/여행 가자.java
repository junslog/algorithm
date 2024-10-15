import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    boolean[][] connected = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      int[] input = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      for (int j = 1; j <= N; j++) {
        connected[i][j] = (input[j - 1] == 1);
      }
    }

    boolean[][] canAccess = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      canAccess[i][i] = true;
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      boolean[] visited = new boolean[N + 1];
      int start = i;
      q.add(start);
      while (!q.isEmpty()) {
        int curr = q.poll();
        visited[curr] = true;
        for (int j = 1; j <= N; j++) {
          if (visited[j]) {
            continue;
          }
          if (connected[curr][j]) {
            canAccess[start][j] = true;
            q.add(j);
          }
        }
      }
    }

    int[] tripRoute = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    int prev, next;
    boolean cantAccess = false;
    for (int i = 0; i < M - 1; i++) {
      prev = tripRoute[i];
      next = tripRoute[i + 1];
      if (!canAccess[prev][next]) {
        cantAccess = true;
        break;
      }
    }

    if (cantAccess) {
      System.out.println("NO");
    } else {
      System.out.println("YES");
    }
  }
}