import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[h][w];

            int numOfIslands = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] || map[i][j] == 0) {
                        continue;
                    }
                    numOfIslands++;
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
            sb.append(numOfIslands).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int startX, int startY) {
        Queue<Land> q = new LinkedList<>();
        q.add(new Land(startX, startY));
        while (!q.isEmpty()) {
            Land elem = q.poll();
            for (int i = 0; i < 8; i++) {
                if (elem.x + dx[i] < 0 || elem.x + dx[i] >= h || elem.y + dy[i] < 0 || elem.y + dy[i] >= w) {
                    continue;
                }
                if (visited[elem.x + dx[i]][elem.y + dy[i]] || map[elem.x + dx[i]][elem.y + dy[i]] == 0) {
                    continue;
                }
                visited[elem.x + dx[i]][elem.y + dy[i]] = true;
                q.add(new Land(elem.x + dx[i], elem.y + dy[i]));
            }
        }
    }

    public static class Land {
        int x;
        int y;

        Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}