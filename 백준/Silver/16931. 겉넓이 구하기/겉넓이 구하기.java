import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int surfaceArea = 2 * N * M;

        int curHeight;
        for (int i = 0; i < M; i++) {
            curHeight = 0;
            for (int j = 0; j < N; j++) {
                if (map[j][i] > curHeight) {
                    surfaceArea += (map[j][i] - curHeight);
                }
                curHeight = map[j][i];
            }
            curHeight = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] > curHeight) {
                    surfaceArea += (map[j][i] - curHeight);
                }
                curHeight = map[j][i];
            }
        }
        for (int i = 0; i < N; i++) {
            curHeight = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] > curHeight) {
                    surfaceArea += (map[i][j] - curHeight);
                }
                curHeight = map[i][j];
            }
            curHeight = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] > curHeight) {
                    surfaceArea += (map[i][j] - curHeight);
                }
                curHeight = map[i][j];
            }
        }
        System.out.println(surfaceArea);
    }
}