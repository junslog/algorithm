import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int tagSequence = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Position[][] map = new Position[N][M];
        char[] currLine;
        for (int i = 0; i < N; i++) {
            currLine = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (currLine[j] - '0' == 0) {
                    map[i][j] = new Position(i, j, 0, false);
                } else {
                    map[i][j] = new Position(i, j, 1, true);
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] taged = new boolean[N][M];
        Queue<Position> q = new ArrayDeque<>();
        Queue<Position> updateP = new ArrayDeque<>();
        // 빈 칸을 기준으로 빈칸그룹들의 maxAdj 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j].isWall && !taged[i][j]) {
                    q.add(map[i][j]);
                    updateP.add(map[i][j]);
                    taged[i][j] = true;
                    int adj = 1;
                    while (!q.isEmpty()) {
                        Position p = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }
                            if (map[nx][ny].isWall) {
                                continue;
                            }
                            if (taged[nx][ny]) {
                                continue;
                            }
                            taged[nx][ny] = true;
                            Position newPos = map[nx][ny];
                            adj++;
                            q.add(newPos);
                            updateP.add(newPos);
                        }
                    }
                    for (Position p : updateP) {
                        p.setTag(tagSequence);
                        p.setAdjMax(adj);
                    }
                    tagSequence++;
                }
                updateP.clear();
            }
        }

        // 벽을 기준으로 BFS, 태그가 서로 다르면서 상하좌우에 새겨진 adjMax값을 각각 더해주고,
        // 1을 더한뒤 ( 벽 자기 자신 ), 10으로 나눈 나머지를 입력해준다.
        Set<Integer> tags = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 벽이면
                if (map[i][j].isWall) {
                    int nextValue = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        Position adjPos = map[nx][ny];
                        // 벽이라면
                        if (adjPos.isWall) {
                            continue;
                        }
                        if (tags.contains(adjPos.tag)) {
                            continue;
                        }
                        tags.add(adjPos.tag);
                        nextValue += adjPos.adjMax;
                    }
                    map[i][j].value = (nextValue + 1) % 10;
                    tags.clear();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j].value);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Position {
        int x;
        int y;
        int value;
        boolean isWall;
        int adjMax;
        int tag;

        Position(int x, int y, int value, boolean isWall) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.isWall = isWall;
        }

        void setAdjMax(int adjMax) {
            this.adjMax = adjMax;
        }

        void setTag(int tag) {
            this.tag = tag;
        }
    }
}