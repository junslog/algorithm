import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adjList;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adjList[i] = new ArrayList<>();
            }
            color = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int source = Integer.parseInt(st.nextToken()) - 1;
                int dest = Integer.parseInt(st.nextToken()) - 1;
                adjList[source].add(dest);
                adjList[dest].add(source);
            }

            for (int j = 0; j < N; j++) {
                if (color[j] == 0) {
                    dfs(j, 1);
                }
            }

            boolean isBiPartitie = true;
            for (int i = 0; i < N; i++) {
                for (int elem : adjList[i]) {
                    if (color[elem] == color[i]) {
                        isBiPartitie = false;
                        break;
                    }
                }
            }

            if (isBiPartitie) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int curr, int c) {
        color[curr] = c;
        for (int elem : adjList[curr]) {
            if (color[elem] == 0) {
                dfs(elem, 3 - c);
            }
        }
    }
}