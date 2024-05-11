import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int rowCount = 0;
        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                rowCount++;
            }
        }

        int colCount = 0;
        for (int i = 0; i < M; i++) {
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 'X') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                colCount++;
            }
        }
        System.out.println(Math.max(rowCount, colCount));
    }
}