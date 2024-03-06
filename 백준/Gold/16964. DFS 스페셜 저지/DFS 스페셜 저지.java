import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] adjList;
    static int[] input;
    static boolean isDFSOrder = true;
    static boolean[] visited;
    static int inputIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            adjList[source].add(dest);
            adjList[dest].add(source);
        }
        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        if (input[0] != 0) {
            System.out.println(0);
            return;
        }
        visited = new boolean[N];
        visited[input[0]] = true;
        dfs(input[0]);
        if (isDFSOrder) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    public static void dfs(int currElem) {
        inputIdx++;
        Set<Integer> adjAndNotVisited = new HashSet<>();
        // 해당 요소에 연결된 원소들 조회
        for (int elem : adjList[currElem]) {
            if (!visited[elem]) {
                adjAndNotVisited.add(elem);
            }
        }

        while (!adjAndNotVisited.isEmpty()) {
            if (adjAndNotVisited.contains(input[inputIdx])) {
                visited[input[inputIdx]] = true;
                adjAndNotVisited.remove(input[inputIdx]);
                dfs(input[inputIdx]);
            } else {
                isDFSOrder = false;
                return;
            }
        }
    }
}