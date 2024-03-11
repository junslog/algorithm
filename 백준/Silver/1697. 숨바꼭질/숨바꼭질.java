import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        q.add(new Node(N, 0));
        visited[N] = true;
        Node target;
        while (true) {
            Node elem = q.poll();
            int currN = elem.value;
            int currDepth = elem.depth;
            if (currN == K) {
                target = elem;
                break;
            } else if (currN > K) {
                if (!visited[currN - 1]) {
                    visited[currN - 1] = true;
                    q.add(new Node(currN - 1, currDepth + 1));
                }
            } else {
                if (currN - 1 >= 0) {
                    if (!visited[currN - 1]) {
                        visited[currN - 1] = true;
                        q.add(new Node(currN - 1, currDepth + 1));
                    }
                }
                if (!visited[currN + 1]) {
                    visited[currN + 1] = true;
                    q.add(new Node(currN + 1, currDepth + 1));
                }
                if (currN * 2 <= 100000) {
                    if (!visited[currN * 2]) {
                        visited[currN * 2] = true;
                        q.add(new Node(currN * 2, currDepth + 1));
                    }
                }
            }
        }
        System.out.println(target.depth);
        br.close();
    }

    public static class Node {
        int value;
        int depth;

        Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}