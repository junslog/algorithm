import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] inputArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = inputArr[j];
            }
        }

        visited = new boolean[N][M];
        int minimum = 9999999;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 <= N - 1 && j + 7 <= M - 1) {
                    char[][] partialMap = makeMap(i, j);
                    boolean[][] visited = new boolean[8][8];
                    minimum = Math.min(minimum, bfs(partialMap, visited, false));

                    char[][] partialMap2 = makeMap(i, j);
                    boolean[][] visited2 = new boolean[8][8];
                    partialMap2[0][0] = (partialMap2[0][0] == 'B' ? 'W' : 'B');
                    minimum = Math.min(minimum, bfs(partialMap2, visited2, true));
                }
            }
        }
        System.out.println(minimum);
    }

    public static char[][] makeMap(int startX, int startY) {
        char[][] newMap = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newMap[i][j] = map[startX + i][startY + j];
            }
        }
        return newMap;
    }

    public static int bfs(char[][] partialMap, boolean[][] visited, boolean flag) {
        int c;
        if (flag) {
            c = 1;
        } else {
            c = 0;
        }
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Position elem = q.poll();
            for (int i = 0; i < 2; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (nx >= 8 || ny >= 8) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (partialMap[nx][ny] == partialMap[elem.x][elem.y]) {
                    partialMap[nx][ny] = partialMap[elem.x][elem.y] == 'W' ? 'B' : 'W';
                    c++;
                }
                q.add(new Position(nx, ny));
            }
        }
        return c;
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