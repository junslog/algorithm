import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] adjList;
    static int[] input;
    static boolean[] visited;
    static Set<Integer> markElems = new HashSet<>();
    static boolean isBFSOrder = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            adjList[source].add(dest);
            adjList[dest].add(source);
        }
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        visited = new boolean[N];
        if (input[0] != 0) {
            System.out.println(0);
            return;
        }
        judgeInputIsbfsOrder();
        if (isBFSOrder) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    public static void judgeInputIsbfsOrder() {
        Queue<Integer> q = new LinkedList<>();
        q.add(input[0]);
        visited[input[0]] = true;
        int idx = 0;
        while (true) {
            int curElem = q.poll();
            for (int i = 0; i < adjList[curElem].size(); i++) {
                if (!visited[adjList[curElem].get(i)]) {
                    markElems.add(adjList[curElem].get(i));
                }
            }
            int counter = markElems.size();
            for (int i = 0; i < counter; i++) {
                idx++;
                if (markElems.contains(input[idx])) {
                    q.add(input[idx]);
                    markElems.remove(input[idx]);
                    visited[input[idx]] = true;
                }
            }
            if (markElems.isEmpty()) {
                if (q.isEmpty()) {
                    return;
                }
            } else {
                isBFSOrder = false;
                return;
            }
        }
    }
}