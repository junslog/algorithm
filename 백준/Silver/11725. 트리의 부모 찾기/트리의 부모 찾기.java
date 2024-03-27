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
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            adjList[source].add(dest);
            adjList[dest].add(source);
        }
        int[] eachValueToParent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int elem = q.poll();
            for (int child : adjList[elem]) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                eachValueToParent[child] = elem;
                q.add(child);
            }
        }
        StringBuilder sb = new StringBuilder(N - 1);
        for (int i = 2; i <= N; i++) {
            sb.append(eachValueToParent[i]).append("\n");
        }
        System.out.println(sb);
    }
}