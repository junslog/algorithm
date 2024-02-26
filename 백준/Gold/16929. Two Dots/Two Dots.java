import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int startX, startY;
    static boolean found;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        // Map Initialize
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                startX = i;
                startY = j;
                visited[i][j] = true;
                dfs(i, j, 0);
                visited[i][j] = false;
            }
        }
        System.out.println("No");
    }

    public static void dfs(int posX, int posY, int depth) {
        for (int i = 0; i < 4; i++) {
            int nx = posX + dx[i];
            int ny = posY + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if (nx == startX && ny == startY && depth >= 3) {
                System.out.println("Yes");
                System.exit(0);
            }
            if (visited[nx][ny] || (map[posX][posY] != map[nx][ny])) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1);
            visited[nx][ny] = false;
        }
    }
}