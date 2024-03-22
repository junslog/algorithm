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
        char[][] map = new char[N][M];
        Position d = new Position(-1, -1);
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (input[j] == 'I') {
                    d = new Position(i, j);
                }
                map[i][j] = input[j];
            }
        }
        Queue<Position> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(d);
        visited[d.x][d.y] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int peopleCount = 0;
        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 'P') {
                    peopleCount++;
                }
                q.add(new Position(nx, ny));
            }
        }
        if (peopleCount > 0) {
            System.out.println(peopleCount);
        } else {
            System.out.println("TT");
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