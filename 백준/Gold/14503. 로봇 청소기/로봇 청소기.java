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
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        // 북 - 동 - 남 - 서 순으로 dx, dy 정렬
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c));
        int numOfRoom = 0;

        while (!q.isEmpty()) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            Node elem = q.poll();
            if (!visited[elem.x][elem.y]) {
                visited[elem.x][elem.y] = true;
                numOfRoom++;
            }
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            // 바라보는 방향을 유지한 채로, 한 칸 후진할 수 있다면 한 칸 후진하고
            // 1번으로 돌아간다.
            // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면, 작동을 멈춘다.
            boolean aroundAllClean = true;
            for (int i = 0; i < 4; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (map[nx][ny] == 1) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    aroundAllClean = false;
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (aroundAllClean) {
                int nx = elem.x + dx[(d + 2) % 4];
                int ny = elem.y + dy[(d + 2) % 4];
                if (map[nx][ny] == 1) {
                    break;
                }
                q.add(new Node(nx, ny));
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 잇는 경우
            else {
                // 반시계 방향으로 90도 회전
                d = (d + 3) % 4;
                int nx = elem.x + dx[d];
                int ny = elem.y + dy[d];
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진
                while (true) {
                    if (visited[nx][ny] || map[nx][ny] == 1) {
                        d = (d + 3) % 4;
                        nx = elem.x + dx[d];
                        ny = elem.y + dy[d];
                        continue;
                    }
                    q.add(new Node(nx, ny));
                    // 1번으로 돌아간다.
                    break;
                }
            }
        }
        System.out.println(numOfRoom);
    }

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}