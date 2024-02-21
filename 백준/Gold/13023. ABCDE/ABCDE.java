import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        // 친구관계 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }
        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int curr, int depth) {
        if (depth == 4) {
            found = true;
            System.out.println(1);
            System.exit(0);
        }

        if (depth >= 5) {
            return;
        }

        for (int friend : adjList[curr]) {
            if (visited[friend]) {
                continue;
            }
            visited[friend] = true;
            dfs(friend, depth + 1);
            visited[friend] = false;
        }
    }
}