import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node>[] adjList;
    static boolean[] visited;
    static int max = -1;
    static int diameterEdge = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // tree Init
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                adjList[source].add(new Node(v, w));
            }
        }
        // Find Tree Diameter
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        max = -1;
        visited = new boolean[N + 1];
        visited[diameterEdge] = true;

        dfs(diameterEdge, 0);
        System.out.println(max);
    }

    public static void dfs(int curr, int cumulativeWeight) {
        for (Node n : adjList[curr]) {
            if (visited[n.idx]) {
                continue;
            }
            visited[n.idx] = true;
            int diffCumulativeWeight = cumulativeWeight + n.weight;
            if (diffCumulativeWeight > max) {
                max = diffCumulativeWeight;
                diameterEdge = n.idx;
            }
            dfs(n.idx, diffCumulativeWeight);
        }
    }

    public static class Node {
        int idx;
        int weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}