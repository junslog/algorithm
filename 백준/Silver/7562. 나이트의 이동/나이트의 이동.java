import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int boardSize;
    static int destX, destY;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            boardSize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            Position knightStartP = new Position(startX, startY);

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());
            visited = new boolean[boardSize][boardSize];
            if (startX == destX && startY == destY) {
                sb.append(0).append("\n");
            } else {
                int minTrial = bfs(knightStartP);
                sb.append(minTrial).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int bfs(Position p) {
        Queue<Position> q = new LinkedList<>();
        q.add(p);
        int qSize = q.size();
        visited[p.x][p.y] = true;
        int trial = 0;
        while (!q.isEmpty()) {
            for (int t = 0; t < qSize; t++) {
                Position elem = q.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = elem.x + dx[i];
                    int ny = elem.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= boardSize || ny >= boardSize) {
                        continue;
                    }

                    if (visited[nx][ny]) {
                        continue;
                    }

                    if (nx == destX && ny == destY) {
                        trial++;
                        return trial;
                    }
                    visited[nx][ny] = true;
                    q.add(new Position(nx, ny));
                }
            }
            qSize = q.size();
            trial++;
        }
        return trial;
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