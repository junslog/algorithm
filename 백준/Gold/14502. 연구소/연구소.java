import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static List<Position> blankSpaces = new ArrayList<>();
    static int blankSpacesSize;
    static boolean[] visited;
    static List<Position> virus = new ArrayList<>();
    static int wallCount;
    static int virusCount;
    static Position[] walls = new Position[3];
    static int maxSafeSpacesSize = -1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blankSpaces.add(new Position(i, j));
                }
                if (board[i][j] == 1) {
                    wallCount++;
                }
                if (board[i][j] == 2) {
                    virus.add(new Position(i, j));
                }
            }
        }
        blankSpacesSize = blankSpaces.size();
        visited = new boolean[blankSpacesSize];
        virusCount = virus.size();
        backtracking(0, 0);
        System.out.println(maxSafeSpacesSize);
    }

    public static void backtracking(int depth, int startIdx) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                board[walls[i].x][walls[i].y] = 1;
            }
            checkSafePlaceSize();
            for (int i = 0; i < 3; i++) {
                board[walls[i].x][walls[i].y] = 0;
            }
            return;
        }

        for (int i = startIdx; i < blankSpacesSize; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            walls[depth] = blankSpaces.get(i);
            backtracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void checkSafePlaceSize() {
        boolean[][] visited = new boolean[N][M];
        int[][] currBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                currBoard[i][j] = board[i][j];
            }
        }
        Queue<Position> q = new ArrayDeque<>();
        for (int i = 0; i < virusCount; i++) {
            Position v = virus.get(i);
            visited[v.x][v.y] = true;
            q.add(v);
        }

        while (!q.isEmpty()) {
            Position v = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (currBoard[nx][ny] == 1 || currBoard[nx][ny] == 2) {
                    continue;
                }
                visited[nx][ny] = true;
                currBoard[nx][ny] = 2;
                q.add(new Position(nx, ny));
            }
        }
        int safePlaceSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currBoard[i][j] == 0) {
                    safePlaceSize++;
                }
            }
        }
        maxSafeSpacesSize = Math.max(maxSafeSpacesSize, safePlaceSize);
    }


    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}