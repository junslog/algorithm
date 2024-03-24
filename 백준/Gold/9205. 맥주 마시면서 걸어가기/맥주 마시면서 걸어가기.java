import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            // Positions[0] : 상범 집
            // Positions[1 ~ N] : 편의점
            // Positions[N+1] : 페스티벌 장소
            List<Position> positions = new ArrayList<>();
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            positions.add(new Position(startX, startY, 0));
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                positions.add(new Position(x, y, i));
            }
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            positions.add(new Position(endX, endY, N + 1));
            int[][] distance = new int[N + 2][N + 2];
            for (int i = 0; i <= N + 1; i++) {
                for (int j = 0; j <= N + 1; j++) {
                    distance[i][j] = positions.get(i).getDistance(positions.get(j));
                }
            }

            Queue<Position> q = new ArrayDeque<>();
            boolean[] visited = new boolean[N + 2];
            q.add(positions.get(0));
            visited[0] = true;

            boolean reached = false;
            while (!q.isEmpty()) {
                Position curr = q.poll();
                int currIdx = curr.idx;
                if (currIdx == N + 1) {
                    reached = true;
                    sb.append("happy").append("\n");
                    break;
                }
                for (int i = 0; i <= N + 1; i++) {
                    if (distance[currIdx][i] > 1000) {
                        continue;
                    }
                    if (visited[i]) {
                        continue;
                    }
                    visited[i] = true;
                    q.add(positions.get(i));
                }
            }
            if (!reached) {
                sb.append("sad").append("\n");
            }
        }
        System.out.println(sb);
    }


    public static class Position {
        int x;
        int y;
        int idx;

        Position(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int getDistance(Position other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }
}