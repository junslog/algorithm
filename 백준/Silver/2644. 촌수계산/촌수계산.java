import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] mark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            adjList[source].add(dest);
            adjList[dest].add(source);
        }
        visited = new boolean[N + 1];
        mark = new int[N + 1];
        bfs();
        if (mark[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(mark[end]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == end) {
                return;
            }
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            for (int elem : adjList[curr]) {
                mark[elem] = mark[curr] + 1;
                q.add(elem);
            }
        }
    }
}