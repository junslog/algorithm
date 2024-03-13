import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int minCrush;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // Map 초기화
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        visited = new boolean[N][M];
        bfs();
        System.out.println(minCrush);
        br.close();
    }

    public static void bfs() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node elem = q.poll();
            if (elem.x == N - 1 && elem.y == M - 1) {
                minCrush = elem.oneCount;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    q.add(new Node(nx, ny, elem.oneCount + 1));
                } else {
                    q.add(new Node(nx, ny, elem.oneCount));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int oneCount;

        Node(int x, int y, int oneCount) {
            this.x = x;
            this.y = y;
            this.oneCount = oneCount;
        }

        @Override
        public int compareTo(Node other) {
            return this.oneCount - other.oneCount;
        }
    }
}