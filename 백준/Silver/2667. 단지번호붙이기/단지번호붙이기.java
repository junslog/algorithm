import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // Map Initialization
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] lineArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(lineArray[j]));
            }
        }
        visited = new boolean[N][N];

        int countOfComplex = 0;
        List<Integer> numOfHousesInComplex = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                countOfComplex++;
                visited[i][j] = true;
                numOfHousesInComplex.add(bfs(new Coordinate(i, j)));
            }
        }

        // 출력
        Collections.sort(numOfHousesInComplex);
        System.out.println(countOfComplex);
        for (int num : numOfHousesInComplex) {
            System.out.println(num);
        }
    }

    public static int bfs(Coordinate c) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(c);
        int count = 0;
        while (!q.isEmpty()) {
            Coordinate elem = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                if (elem.x + dx[i] < 0 || elem.x + dx[i] >= N || elem.y + dy[i] < 0 || elem.y + dy[i] >= N) {
                    continue;
                }
                if (visited[elem.x + dx[i]][elem.y + dy[i]] || map[elem.x + dx[i]][elem.y + dy[i]] == 0) {
                    continue;
                }
                visited[elem.x + dx[i]][elem.y + dy[i]] = true;
                q.add(new Coordinate(elem.x + dx[i], elem.y + dy[i]));
            }
        }
        return count;
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