import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(startX, startY, 0));
        visited[startX][startY] = true;
        int answer = -1;
        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int currStep = p.step;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (nx == endX && ny == endY) {
                    answer = currStep + 1;
                    q.clear();
                    break;
                }
                q.add(new Position(nx, ny, currStep + 1));
            }
        }
        System.out.println(answer);
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