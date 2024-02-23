import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int minimumCount = 1;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // Map Initialization
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] lineArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(lineArray[j]));
            }
        }
        visited = new boolean[N][M];
        bfs();
        System.out.println(minimumCount);
    }

    public static void bfs() {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0));
        int qSize = q.size();
        while (!q.isEmpty()) {
            for (int step = 0; step < qSize; step++) {
                Coordinate elem = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (elem.x + dx[i] < 0 || elem.x + dx[i] >= N || elem.y + dy[i] < 0 || elem.y + dy[i] >= M) {
                        continue;
                    }
                    if (visited[elem.x + dx[i]][elem.y + dy[i]] || map[elem.x + dx[i]][elem.y + dy[i]] == 0) {
                        continue;
                    }

                    if (elem.x + dx[i] == N - 1 && elem.y + dy[i] == M - 1) {
                        minimumCount++;
                        return;
                    }
                    visited[elem.x + dx[i]][elem.y + dy[i]] = true;
                    q.add(new Coordinate(elem.x + dx[i], elem.y + dy[i]));
                }
            }
            qSize = q.size();
            minimumCount++;
        }
    }

    public static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}