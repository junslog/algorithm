import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, L, R;
  static int[][] A;
  static Queue<Position> q = new ArrayDeque<>();
  static List<Position> l = new ArrayList<>();
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;
  static boolean isMoved;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    A = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int dayCnt = 0;
    while (true) {
      isMoved = false;
      visited = new boolean[N][N];

      // 인구 이동
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (visited[i][j]) {
            continue;
          }
          bfs(i, j);
        }
      }
      
      if (!isMoved) {
        break;
      }
      dayCnt++;
    }
    System.out.println(dayCnt);
  }

  static class Position {

    int x;
    int y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  // 인구 이동 및 인구 업데이트
  private static void bfs(int x, int y) {
    Position initP = new Position(x, y);
    q.add(initP);
    l.add(initP);
    int peopleCnt = A[x][y];
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Position p = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
          continue;
        }

        if (visited[nx][ny]) {
          continue;
        }

        int peopleGap = Math.abs(A[p.x][p.y] - A[nx][ny]);
        if (peopleGap >= L && peopleGap <= R) {
          visited[nx][ny] = true;
          Position pp = new Position(nx, ny);
          q.add(pp);
          l.add(pp);
          peopleCnt += A[nx][ny];
        }

      }
    }

    int avgPeopleCntInArea = peopleCnt / l.size();
    if (l.size() > 1) {
      isMoved = true;
    }
    for (Position p : l) {
      A[p.x][p.y] = avgPeopleCntInArea;
    }
    l.clear();
  }
}
