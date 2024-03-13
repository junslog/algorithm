import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new Node(N, 0));
        int minCount;
        while (true) {
            Node elem = q.poll();
            int v = elem.value;
            if (v == 1) {
                minCount = elem.opCount;
                break;
            }
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            int oc = elem.opCount;
            if (v % 3 == 0) {
                q.add(new Node(v / 3, oc + 1));
            }
            if (v % 2 == 0) {
                q.add(new Node(v / 2, oc + 1));
            }
            if (v >= 2) {
                q.add(new Node(v - 1, oc + 1));
            }
        }
        System.out.println(minCount);
    }

    public static class Node {
        int value;
        int opCount;

        Node(int value, int opCount) {
            this.value = value;
            this.opCount = opCount;
        }
    }
}