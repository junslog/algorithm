import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // Init Cabbage Place
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }
            visited = new boolean[N][M];

            int wormCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || map[i][j] == 0) {
                        continue;
                    }
                    visited[i][j] = true;
                    wormCount++;
                    bfs(i, j);
                }
            }
            sb.append(wormCount).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int startX, int startY) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(startX, startY));
        while (!q.isEmpty()) {
            Position elem = q.poll();
            for (int i = 0; i < dx.length; i++) {
                if (elem.x + dx[i] < 0 || elem.x + dx[i] >= N || elem.y + dy[i] < 0 || elem.y + dy[i] >= M) {
                    continue;
                }
                if (visited[elem.x + dx[i]][elem.y + dy[i]] || map[elem.x + dx[i]][elem.y + dy[i]] == 0) {
                    continue;
                }
                visited[elem.x + dx[i]][elem.y + dy[i]] = true;
                q.add(new Position(elem.x + dx[i], elem.y + dy[i]));
            }
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