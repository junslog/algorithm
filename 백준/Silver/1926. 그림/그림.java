import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] draw;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        draw = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                draw[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Position> q = new LinkedList<>();
        visited = new boolean[n][m];
        int drawCount = 0;
        int maxWidth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || draw[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                drawCount++;
                int width = 1;
                q.add(new Position(i, j));
                while (!q.isEmpty()) {
                    Position p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            continue;
                        }
                        if (visited[nx][ny] || draw[nx][ny] == 0) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        q.add(new Position(nx, ny));
                        width++;
                    }
                }
                if (maxWidth < width) {
                    maxWidth = width;
                }
            }
        }
        System.out.println(drawCount);
        System.out.println(maxWidth);
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