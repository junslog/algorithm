import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Position[][] board = new Position[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = new Position(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] visited = new boolean[N][M];

        int answer = -1;
        while (true) {
            year++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Position p = board[i][j];
                    if (p.isOcean()) {
                        continue;
                    }
                    int lazyUpdateMinus = 0;
                    // 빙산인 경우
                    for (int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                            continue;
                        }
                        if (board[nx][ny].isOcean()) {
                            lazyUpdateMinus++;
                        }
                    }
                    if (p.height - lazyUpdateMinus <= 0) {
                        p.lazyUpdateHeight = 0;
                    } else {
                        p.lazyUpdateHeight = p.height - lazyUpdateMinus;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Position p = board[i][j];
                    if (p.isOcean()) {
                        continue;
                    }
                    p.height = p.lazyUpdateHeight;
                    if (p.isIceBerg()) { // 빙산이면
                        visited[p.x][p.y] = false;
                    }
                }
            }

            int deungi = 0;
            Queue<Position> q = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j].isOcean()) {
                        continue;
                    }
                    if (visited[i][j]) {
                        continue;
                    }
                    // 빙산이면
                    visited[i][j] = true;
                    q.add(board[i][j]);
                    deungi++;
                    while (!q.isEmpty()) {
                        Position p = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                                continue;
                            }
                            if (visited[nx][ny] || board[nx][ny].isOcean()) {
                                continue;
                            }
                            visited[nx][ny] = true;
                            q.add(board[nx][ny]);
                        }
                    }
                }
            }

            // 다 녹았으면
            if (deungi == 0) {
                answer = 0;
                break;
            }

            if (deungi >= 2) {
                answer = year;
                break;
            }
        }
        System.out.println(answer);
    }

    static class Position {
        int x;
        int y;
        int height;
        int lazyUpdateHeight;

        Position(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.lazyUpdateHeight = height;
        }

        boolean isIceBerg() {
            return height > 0;
        }

        boolean isOcean() {
            return height == 0;
        }
    }
}