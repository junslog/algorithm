import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i, j);
            }
        }
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        // 1. oooo
        if (x + 3 < N) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += map[x + i][y];
            }
            max = Math.max(max, sum);
        }
        if (y + 3 < M) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += map[x][y + i];
            }
            max = Math.max(max, sum);
        }
        if (x - 3 >= 0) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += map[x - i][y];
            }
            max = Math.max(max, sum);
        }
        if (y - 3 >= 0) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += map[x][y - i];
            }
            max = Math.max(max, sum);
        }
        // 2. oo
        //    oo
        if (x + 1 < N && y + 1 < M) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x][y + 1] + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }
        // 3. o o o
        //      o
        if (y + 2 < M && x + 1 < N) {
            int sum = map[x][y] + map[x][y + 1] + map[x][y + 2]
                    + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y + 1 < M) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 2][y] + map[x - 1][y + 1];
            max = Math.max(max, sum);
        }
        if (y - 2 >= 0 && x - 1 >= 0) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x][y - 2] + map[x - 1][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 2 < N && y - 1 >= 0) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 2][y] + map[x + 1][y - 1];
            max = Math.max(max, sum);
        }

        // 4.  o
        //   o o o
        if (x - 1 >= 0 && y + 2 < M) {
            int sum = map[x][y] + map[x][y + 1]
                    + map[x][y + 2] + map[x - 1][y + 1];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 2][y] + map[x - 1][y - 1];
            max = Math.max(max, sum);
        }
        if (y - 2 >= 0 && x + 1 < N) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x][y - 2] + map[x + 1][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 2 < N && y + 1 < M) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 2][y] + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }

        // 5. o
        //    o
        //    o o
        if (x + 2 < N && y + 1 < M) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 2][y] + map[x + 2][y + 1];
            max = Math.max(max, sum);
        }
        if (x - 1 >= 0 && y + 2 < M) {
            int sum = map[x][y] + map[x][y + 1]
                    + map[x][y + 2] + map[x - 1][y + 2];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 2][y] + map[x - 2][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 1 < N && y - 2 >= 0) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x][y - 2] + map[x + 1][y - 2];
            max = Math.max(max, sum);
        }

        // 6. o
        //    o
        //  o o
        if (x + 2 < N && y - 1 >= 0) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 2][y] + map[x + 2][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 1 < N && y + 2 < M) {
            int sum = map[x][y] + map[x][y + 1]
                    + map[x][y + 2] + map[x + 1][y + 2];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y + 1 < M) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 2][y] + map[x - 2][y + 1];
            max = Math.max(max, sum);
        }
        if (y - 2 >= 0 && x - 1 >= 0) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x][y - 2] + map[x - 1][y - 2];
            max = Math.max(max, sum);
        }
        // 7. o
        //    o o
        //      o
        if (x + 2 < N && y + 1 < M) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 1][y + 1] + map[x + 2][y + 1];
            max = Math.max(max, sum);
        }
        if (x - 1 >= 0 && y + 2 < M) {
            int sum = map[x][y] + map[x][y + 1]
                    + map[x - 1][y + 1] + map[x - 1][y + 2];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 1][y - 1] + map[x - 2][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 1 < N && y - 2 >= 0) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x + 1][y - 1] + map[x + 1][y - 2];
            max = Math.max(max, sum);
        }

        // 8.   o
        //    o o
        //    o
        if (x + 2 < N && y - 1 >= 0) {
            int sum = map[x][y] + map[x + 1][y]
                    + map[x + 1][y - 1] + map[x + 2][y - 1];
            max = Math.max(max, sum);
        }
        if (x + 1 < N && y + 2 < M) {
            int sum = map[x][y] + map[x][y + 1]
                    + map[x + 1][y + 1] + map[x + 1][y + 2];
            max = Math.max(max, sum);
        }
        if (x - 2 >= 0 && y + 1 < M) {
            int sum = map[x][y] + map[x - 1][y]
                    + map[x - 1][y + 1] + map[x - 2][y + 1];
            max = Math.max(max, sum);
        }
        if (y - 2 >= 0 && x - 1 >= 0) {
            int sum = map[x][y] + map[x][y - 1]
                    + map[x - 1][y - 1] + map[x - 1][y - 2];
            max = Math.max(max, sum);
        }
    }
}