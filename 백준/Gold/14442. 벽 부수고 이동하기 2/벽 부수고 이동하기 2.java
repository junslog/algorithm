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
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j] - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[][] minWallBroke = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                minWallBroke[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new Node(0, 0, 0, 0));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int minStep = -1;
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                int nWallBroke = n.wallBroke;
                int currStep = n.step;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (nx == N - 1 && ny == M - 1) {
                    minStep = currStep + 2;
                    q.clear();
                    break;
                }

                if (visited[nx][ny]) {
                    if (minWallBroke[nx][ny] <= nWallBroke) {
                        continue;
                    }
                    if (nWallBroke == K) {
                        continue;
                    }
                    minWallBroke[nx][ny] = nWallBroke;
                    if (board[nx][ny] == 0) {
                        q.add(new Node(nx, ny, currStep + 1, nWallBroke));
                    } else if (board[nx][ny] == 1) {
                        q.add(new Node(nx, ny, currStep + 1, nWallBroke + 1));
                    }
                } else {
                    visited[nx][ny] = true;
                    minWallBroke[nx][ny] = nWallBroke;
                    if (board[nx][ny] == 0) {
                        q.add(new Node(nx, ny, currStep + 1, nWallBroke));
                    } else if (board[nx][ny] == 1) {
                        if (nWallBroke == K) {
                            continue;
                        }
                        q.add(new Node(nx, ny, currStep + 1, nWallBroke + 1));
                    }
                }
            }
        }
        if (N == 1 && M == 1) {
            System.out.println(1);
        } else {
            System.out.println(minStep);
        }
    }

    public static class Node {
        int x;
        int y;
        int step;
        int wallBroke;

        Node(int x, int y, int step, int wallBroke) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.wallBroke = wallBroke;
        }
    }
}