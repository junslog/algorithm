import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static List<Integer>[] adjList;
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }
        visited[V] = true;
        dfsSb.append(V).append(" ");
        dfs(V);
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        bfs();
        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    public static void dfs(int curr) {
        for (int i : adjList[curr]) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfsSb.append(i).append(" ");
            dfs(i);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            bfsSb.append(curr).append(" ");
            for (int i : adjList[curr]) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                q.add(i);
            }
        }
    }
}