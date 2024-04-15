import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int minButtonCount = 100;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int coinCount = 0;
        // 동전의 위치
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int i = 0; i < N; i++) {
            char[] currLine = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (currLine[j] == 'o') {
                    if (coinCount == 0) {
                        x1 = i;
                        y1 = j;
                        coinCount++;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
                map[i][j] = currLine[j];
            }
        }
        backtracking(0, map, new CoinPosition(x1, y1), new CoinPosition(x2, y2));
        if (minButtonCount > 10) {
            System.out.println(-1);
        } else {
            System.out.println(minButtonCount);
        }
    }

    public static void backtracking(int depth, char[][] map,
                                    CoinPosition c1, CoinPosition c2) {
        if (depth > 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            boolean coin1Move = false;
            boolean coin1Drop = false;
            boolean coin2Move = false;
            boolean coin2Drop = false;

            // 동전 첫번째 이동 위치
            int nx1 = c1.x + dx[i];
            int ny1 = c1.y + dy[i];

            if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
                coin1Drop = true;
            }
            if (!coin1Drop) {
                if (map[nx1][ny1] == '.' || map[nx1][ny1] == 'o') {
                    coin1Move = true;
                } else {
                    nx1 = c1.x;
                    ny1 = c1.y;
                }
            }

            // 동전 두번째
            int nx2 = c2.x + dx[i];
            int ny2 = c2.y + dy[i];

            if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
                coin2Drop = true;
            }

            if (!coin2Drop) {
                if (map[nx2][ny2] == '.' || map[nx2][ny2] == 'o') {
                    coin2Move = true;
                } else {
                    nx2 = c2.x;
                    ny2 = c2.y;
                }
            }

            // 두 동전 모두 떨어진 경우
            if (coin1Drop && coin2Drop) {
                continue;
            }

            // 두 동전 중 하나만 떨어진 경우
            if (coin1Drop) {
                minButtonCount = Math.min(minButtonCount, depth + 1);
                return;
            }
            if (coin2Drop) {
                minButtonCount = Math.min(minButtonCount, depth + 1);
                return;
            }

            // 예외처리 - 두 동전이 겹친 경우
            if (nx1 == nx2 && ny1 == ny2) {
                continue;
            }

            // 두 동전 모두 못움직인 경우
            if (!coin1Move && !coin2Move) {
                continue;
            }

            char[][] newMap = new char[N][M];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    newMap[n][m] = map[n][m];
                }
            }

            // 두 동전 중 하나만 움직인 경우
            if (coin1Move) {
                newMap[c1.x][c1.y] = '.';
                newMap[nx1][ny1] = 'o';
            }
            if (coin2Move) {
                newMap[c2.x][c2.y] = '.';
                newMap[nx2][ny2] = 'o';
            }
            backtracking(depth + 1, newMap
                    , new CoinPosition(nx1, ny1),
                    new CoinPosition(nx2, ny2));
        }
    }

    public static class CoinPosition {
        int x;
        int y;

        CoinPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}