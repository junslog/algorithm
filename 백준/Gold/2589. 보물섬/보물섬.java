import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j];
            }
        }

        int maxStep = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Position> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'W') {
                    continue;
                }
                boolean[][] visited = new boolean[N][M];
                q.add(new Position(i, j, 0));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Position p = q.poll();
                    int currStep = p.step;
                    boolean existAround = false;
                    for (int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                            continue;
                        }

                        if (visited[nx][ny] || board[nx][ny] == 'W') {
                            continue;
                        }
                        visited[nx][ny] = true;
                        existAround = true;
                        q.add(new Position(nx, ny, currStep + 1));
                    }
                    if (!existAround) {
                        maxStep = Math.max(maxStep, currStep);
                    }
                }
            }
        }
        System.out.println(maxStep);
    }

    public static class Position {
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