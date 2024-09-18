import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] matrix = new int[n][m];
    Queue<Position> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
        if (matrix[i][j] == 2) {
          q.add(new Position(i, j, 0));
          visited[i][j] = true;
        }
      }
    }

    int[][] answerMatrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          answerMatrix[i][j] = 0;
        } else {
          answerMatrix[i][j] = -1;
        }
      }
    }

    while (!q.isEmpty()) {
      Position p = q.poll();
      answerMatrix[p.x][p.y] = p.step;
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }
        if (matrix[nx][ny] == 0) {
          continue;
        }
        if (visited[nx][ny]) {
          continue;
        }
        visited[nx][ny] = true;
        q.add(new Position(nx, ny, p.step + 1));
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(answerMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static class Position {

    int x;
    int y;
    int step;

    Position(int x, int y, int step) {
      this.x = x;
      this.y = y;
      this.step = step;
    }
  }
}