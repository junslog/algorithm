import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static List<Island> islands = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 찾고 mark
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    List<Element> area = new ArrayList<>();
                    findIslands(area, new Element(i, j));
                    islands.add(new Island(area));
                }
            }
        }
        int minimumDistance = 99999999;
        // 각 섬의 요소별로 거리 측정, 최소값 구하기
        for (int i = 0; i < islands.size(); i++) {
            Island firstIsland = islands.get(i);
            for (int j = i + 1; j < islands.size(); j++) {
                Island secondIsland = islands.get(j);
                int min = findMinimumDistance(firstIsland, secondIsland);
                if (minimumDistance > min) {
                    minimumDistance = min;
                }
            }
        }
        System.out.println(minimumDistance);
    }

    public static void findIslands(List<Element> area, Element firstElem) {
        Queue<Element> q = new ArrayDeque<>();
        area.add(firstElem);
        q.add(firstElem);
        while (!q.isEmpty()) {
            Element elem = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                Element newElem = new Element(nx, ny);
                area.add(newElem);
                q.add(newElem);
            }
        }
    }

    public static int findMinimumDistance(Island is1, Island is2) {
        List<Element> area1 = is1.area;
        List<Element> area2 = is2.area;
        int minimum = 999999999;
        for (Element elem1 : area1) {
            for (Element elem2 : area2) {
                int gap = elem1.getDistance(elem2);
                if (gap < minimum) {
                    minimum = gap;
                }
            }
        }
        return minimum;
    }

    public static class Island {
        List<Element> area;

        Island(List<Element> area) {
            this.area = area;
        }
    }

    public static class Element {
        int x;
        int y;

        Element(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getDistance(Element other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y) - 1;
        }
    }
}