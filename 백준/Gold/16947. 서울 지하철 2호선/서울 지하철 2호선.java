import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static boolean[] isInCycle;
    static int[] distanceFromCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            adjList[source].add(dest);
            adjList[dest].add(source);
        }

        // Cycle 여부 판별
        visited = new boolean[N];
        isInCycle = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, -1, i);
            visited[i] = false;
        }

        distanceFromCycle = new int[N];
        for (int i = 0; i < N; i++) {
            if (isInCycle[i]) {
                distanceFromCycle[i] = 0;
                findDistanceFromCycle(i, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(distanceFromCycle[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int prev, int curr) {
        for (int elem : adjList[curr]) {
            if (prev != start && elem == start) {
                isInCycle[start] = true;
                return;
            }
            if (visited[elem]) {
                continue;
            }
            visited[elem] = true;
            dfs(start, curr, elem);
            visited[elem] = false;
        }
    }

    public static void findDistanceFromCycle(int source, int depth) {
        visited[source] = true;
        for (int elem : adjList[source]) {
            if (isInCycle[elem]) {
                continue;
            }
            if (visited[elem]) {
                continue;
            }
            distanceFromCycle[elem] = depth + 1;
            findDistanceFromCycle(elem, depth + 1);
        }
        visited[source] = false;
    }
}