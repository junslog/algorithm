import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] adjList;
    static int max = -1;
    static int diameterNum = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[source].add(new Node(dest, weight));
            adjList[dest].add(new Node(source, weight));
        }
        if (N > 1) {
            visited = new boolean[N + 1];
            visited[1] = true;
            dfs(1, 0);

            visited = new boolean[N + 1];
            visited[diameterNum] = true;
            dfs(diameterNum, 0);
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int curr, int cumulativeWeight) {
        for (Node n : adjList[curr]) {
            if (visited[n.idx]) {
                continue;
            }
            visited[n.idx] = true;
            int addedWeight = cumulativeWeight + n.weight;
            if (addedWeight > max) {
                max = addedWeight;
                diameterNum = n.idx;
            }
            dfs(n.idx, addedWeight);
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