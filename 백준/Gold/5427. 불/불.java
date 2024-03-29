import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 1. 각 배열 요소마다 불이 번지는 최소 시간들을 표시해준다.
        // 2. 상범이가 길을 가는데, 상범이의 step > 불이 도착한 시간 이면 못감.
        // 3. 2번의 조건으로 BFS를 진행했을 때, 출구 ( nx = -1 or w || ny = -1 or h ) 도착 히, 그 때의 최솟값이 답임.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            Position[][] map = new Position[h][w];
            Position sanguen = null;
            for (int i = 0; i < h; i++) {
                char[] curLine = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = new Position(curLine[j], i, j);
                    if (map[i][j].isSangeun()) {
                        sanguen = map[i][j];
                    }
                }
            }

            // 0. 불 위치 detect
            Queue<Position> fq = new ArrayDeque<>();
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!map[i][j].isFire()) {
                        continue;
                    }
                    map[i][j].fireMinStep = 0;
                    visited[i][j] = true;
                    fq.add(map[i][j]);
                }
            }
            while (!fq.isEmpty()) {
                Position p = fq.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }
                    if (visited[nx][ny] || map[nx][ny].isWall() || map[nx][ny].isFire()) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    if (p.fireMinStep + 1 < map[nx][ny].fireMinStep) {
                        map[nx][ny].fireMinStep = p.fireMinStep + 1;
                    }
                    fq.add(map[nx][ny]);
                }
            }
            // 2. 상근이 최단거리 마킹, 가능한 최단거리 반환
            Queue<Position> sq = new ArrayDeque<>();
            visited = new boolean[h][w];
            int minStep = -1;
            boolean escaped = false;
            sanguen.sangeunMinStep = 0;
            sq.add(sanguen);
            while (!sq.isEmpty()) {
                if (escaped) {
                    break;
                }
                Position p = sq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx == h || nx == -1 || ny == w || ny == -1) {
                        minStep = p.sangeunMinStep + 1;
                        escaped = true;
                        break;
                    }
                    if (visited[nx][ny] || map[nx][ny].isWall() || map[nx][ny].isFire()) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    map[nx][ny].sangeunMinStep = p.sangeunMinStep + 1;
                    if (map[nx][ny].sangeunMinStep >= map[nx][ny].fireMinStep) {
                        continue;
                    }
                    sq.add(map[nx][ny]);
                }
            }
            if (escaped) {
                System.out.println(minStep);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static class Position {
        char type;
        int x;
        int y;
        int fireMinStep;
        int sangeunMinStep;

        Position(char type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.fireMinStep = 1000 * 1001;
            this.sangeunMinStep = 1000 * 1001;
        }

        boolean isWall() {
            return this.type == '#';
        }

        boolean isSangeun() {
            return this.type == '@';
        }

        boolean isFire() {
            return this.type == '*';
        }
    }
}