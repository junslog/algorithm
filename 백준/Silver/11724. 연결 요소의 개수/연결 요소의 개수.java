import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] check;
    static int numOfConnected = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            adjList[source].add(dest);
            adjList[dest].add(source);
        }

        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (check[i]) {
                continue;
            }
            numOfConnected++;
            dfs(i);
        }
        System.out.println(numOfConnected);
    }

    public static void dfs(int curr) {
        for (int elem : adjList[curr]) {
            if (check[elem]) {
                continue;
            }
            check[elem] = true;
            dfs(elem);
        }
    }
}