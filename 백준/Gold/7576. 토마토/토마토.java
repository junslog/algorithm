import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Position> tomatoes;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        tomatoes = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0 || map[i][j] == -1) {
                    continue;
                }
                visited[i][j] = true;
                tomatoes.add(new Position(i, j));
            }
        }
        while (true) {
            flag = true;
            tomatoes = bfs();
            if (flag) {
                break;
            }
            day++;
        }

        boolean allTomatoes = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    allTomatoes = false;
                    break;
                }
            }
        }

        if (allTomatoes) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static Queue<Position> bfs() {
        Queue<Position> t = new LinkedList<>();

        while (!tomatoes.isEmpty()) {
            Position tomatoPos = tomatoes.poll();
            for (int i = 0; i < 4; i++) {
                if (tomatoPos.x + dx[i] < 0 || tomatoPos.y + dy[i] < 0 || tomatoPos.x + dx[i] >= M
                        || tomatoPos.y + dy[i] >= N) {
                    continue;
                }
                if (visited[tomatoPos.x + dx[i]][tomatoPos.y + dy[i]]
                        || map[tomatoPos.x + dx[i]][tomatoPos.y + dy[i]] == -1) {
                    continue;
                }
                map[tomatoPos.x + dx[i]][tomatoPos.y + dy[i]] = 1;
                visited[tomatoPos.x + dx[i]][tomatoPos.y + dy[i]] = true;
                t.add(new Position(tomatoPos.x + dx[i], tomatoPos.y + dy[i]));
                flag = false;
            }
        }
        return t;
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