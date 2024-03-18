import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static int maximumSafeArea = -1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= 100; i++) {
            bfs(i);
        }
        if (maximumSafeArea == 0) {
            System.out.println(1);
        } else {
            System.out.println(maximumSafeArea);
        }
    }

    public static void bfs(int threshold) {
        int area = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] <= threshold) {
                    continue;
                }
                visited[i][j] = true;
                area++;

                Queue<Position> q = new LinkedList<>();
                q.add(new Position(i, j));
                while (!q.isEmpty()) {
                    Position p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }
                        if (visited[nx][ny] || map[nx][ny] <= threshold) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        q.add(new Position(nx, ny));
                    }
                }
            }
        }
        if (area > maximumSafeArea) {
            maximumSafeArea = area;
        }
    }

    public static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}