import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] originBox = new int[N][M][H];
        Queue<Position> ripenTomatoes = new ArrayDeque<>();
        boolean existUnripenTomatoes = false;
        boolean[][][] visited = new boolean[N][M][H];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    originBox[n][m][h] = Integer.parseInt(st.nextToken());
                    if (originBox[n][m][h] == 1) {
                        ripenTomatoes.add(new Position(n, m, h, 0));
                        visited[n][m][h] = true;
                    }
                    if (originBox[n][m][h] == 0) {
                        existUnripenTomatoes = true;
                    }
                }
            }
        }
        if (!existUnripenTomatoes) {
            System.out.println(0);
        } else {
            int step = -1;
            while (!ripenTomatoes.isEmpty()) {
                Position p = ripenTomatoes.poll();
                step = p.step;
                for (int i = 0; i < 6; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                        continue;
                    }
                    if (visited[nx][ny][nz]) {
                        continue;
                    }
                    visited[nx][ny][nz] = true;
                    if (originBox[nx][ny][nz] == -1 || originBox[nx][ny][nz] == 1) {
                        continue;
                    }
                    if (originBox[nx][ny][nz] == 0) {
                        originBox[nx][ny][nz] = 1;
                        ripenTomatoes.add(new Position(nx, ny, nz, step + 1));
                    }
                }
            }

            boolean isAllRipen = true;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (originBox[j][k][i] == 0) {
                            isAllRipen = false;
                            break;
                        }
                    }
                }
            }
            if (isAllRipen) {
                System.out.println(step);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static class Position {
        int x;
        int y;
        int z;
        int step;

        Position(int x, int y, int z, int step) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.step = step;
        }
    }
}