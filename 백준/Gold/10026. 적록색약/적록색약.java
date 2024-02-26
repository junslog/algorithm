import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static char[][] mapRG;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        mapRG = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    mapRG[i][j] = 'R';
                    continue;
                }
                mapRG[i][j] = map[i][j];
            }
        }

        // 적록색약인 사람 보는 구간 개수 count
        visited = new boolean[N][N];
        int spaceCountWithBlindness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                spaceCountWithBlindness++;
                bfsWithBlindness(i, j);
            }
        }
        // 적록색얀 아닌 사람 보는 구간 개수 count
        visited = new boolean[N][N];
        int spaceCountWithoutBlindness = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                spaceCountWithoutBlindness++;
                bfsWithoutBlindness(i, j);
            }
        }

        System.out.println(spaceCountWithoutBlindness + " " + spaceCountWithBlindness);
        br.close();
    }

    public static void bfsWithBlindness(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point elem = q.poll();
            char color = mapRG[elem.x][elem.y];
            for (int k = 0; k < 4; k++) {
                int nx = elem.x + dx[k];
                int ny = elem.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || color != mapRG[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static void bfsWithoutBlindness(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point elem = q.poll();
            char color = map[elem.x][elem.y];
            for (int k = 0; k < 4; k++) {
                int nx = elem.x + dx[k];
                int ny = elem.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || color != map[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}