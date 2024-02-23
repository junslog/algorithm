import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int N, M;
    static int numOfDefected = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            adjList[source].add(dest);
            adjList[dest].add(source);
        }
        visited = new boolean[N];
        visited[0] = true;
        dfs(0);
        System.out.println(numOfDefected);
    }

    public static void dfs(int curr) {
        for (int elem : adjList[curr]) {
            if (visited[elem]) {
                continue;
            }
            visited[elem] = true;
            numOfDefected++;
            dfs(elem);
        }
    }
}