import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        List<Integer> histoires = new ArrayList<>();
        q.add(new Node(N, 0).addHistory(histoires));
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
                    q.add(new Node(currN - 1, currDepth + 1, elem.histories));
                }
            } else {
                if (currN - 1 >= 0) {
                    if (!visited[currN - 1]) {
                        visited[currN - 1] = true;
                        q.add(new Node(currN - 1, currDepth + 1).addHistory(elem.histories));
                    }
                }
                if (!visited[currN + 1]) {
                    visited[currN + 1] = true;
                    q.add(new Node(currN + 1, currDepth + 1).addHistory(elem.histories));
                }
                if (currN * 2 <= 100000) {
                    if (!visited[currN * 2]) {
                        visited[currN * 2] = true;
                        q.add(new Node(currN * 2, currDepth + 1).addHistory(elem.histories));
                    }
                }
            }
        }
        System.out.println(target.depth);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.histories.size(); i++) {
            sb.append(target.histories.get(i)).append(" ");
        }
        System.out.println(sb);

        br.close();
    }

    public static class Node {
        int value;
        int depth;
        List<Integer> histories;

        Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        Node(int value, int depth, List<Integer> histories) {
            this.value = value;
            this.depth = depth;
            this.histories = histories;
            histories.add(value);
        }

        Node addHistory(List<Integer> histories) {
            this.histories = new ArrayList<>();
            this.histories.addAll(histories);
            this.histories.add(value);
            return this;
        }
    }
}