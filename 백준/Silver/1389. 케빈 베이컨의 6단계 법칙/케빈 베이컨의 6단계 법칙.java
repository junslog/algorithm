import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        int[] sum = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                sum[i] = bfs(i);
                Arrays.fill(check, false);
            }
        }

        int min = 9999999;
        int minIdx = 0;
        for (int i = 0; i < N; i++) {
            if (min > sum[i]) {
                min = sum[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx + 1);
    }

    public static int bfs(int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        check[source] = true;
        int count = 0;
        int depth = 1;
        int qSize = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < qSize; i++) {
                int elem = q.poll();
                for (int d : adjList[elem]) {
                    if (check[d]) {
                        continue;
                    }
                    check[d] = true;
                    q.add(d);
                    count += depth;
                }
            }
            qSize = q.size();
            depth++;
        }
        return count;
    }
}