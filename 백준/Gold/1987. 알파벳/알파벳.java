import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] board;
    static int alphabetSize = 'Z' - 'A' + 1;
    static int maxDepth;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxStep = Integer.MIN_VALUE;

    static boolean[][] visited;
    static boolean[] contains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = chars[j];
                s.add(board[i][j]);
            }
        }
        maxDepth = s.size();

        visited = new boolean[R][C];
        visited[0][0] = true;
        contains = new boolean[alphabetSize];
        contains[board[0][0] - 'A'] = true;
        backtracking(1, 0, 0);
        System.out.println(maxStep);
    }

    public static void backtracking(int depth, int currX, int currY) {

        for (int i = 0; i < 4; i++) {
            int nx = currX + dx[i];
            int ny = currY + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                maxStep = Math.max(maxStep, depth);
                continue;
            }

            if (visited[nx][ny] || contains[board[nx][ny] - 'A']) {
                maxStep = Math.max(maxStep, depth);
                continue;
            }

//            boolean[][] visitedUpdate = new boolean[R][C];
//            boolean[] containsUpdate = new boolean[alphabetSize];
//            for (int r = 0; r < R; r++) {
//                for (int c = 0; c < C; c++) {
//                    visitedUpdate[r][c] = visited[r][c];
//                }
//            }
//            for (int co = 0; co < alphabetSize; co++) {
//                containsUpdate[co] = contains[co];
//            }
            visited[nx][ny] = true;
            contains[board[nx][ny] - 'A'] = true;
            backtracking(depth + 1, nx, ny);
            contains[board[nx][ny] - 'A'] = false;
            visited[nx][ny] = false;
        }
    }
}