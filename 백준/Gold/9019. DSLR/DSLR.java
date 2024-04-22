import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answerList = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];

            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(start, new StringBuilder()));
            visited[start] = true;
            String answer = "";
            while (!q.isEmpty()) {
                Node curr = q.poll();
                int currValue = curr.value;
                StringBuilder currSb = curr.sb;

                if (currValue == target) {
                    q.clear();
                    answer = currSb.toString();
                    break;
                }

                // D
                int d = (currValue * 2) % 10000;
                if (!visited[d]) {
                    visited[d] = true;
                    q.add(new Node(d, new StringBuilder(currSb.toString()).append("D")));
                }

                // S
                int s = (currValue - 1) < 0 ? 9999 : currValue - 1;
                if (!visited[s]) {
                    visited[s] = true;
                    q.add(new Node(s, new StringBuilder(currSb.toString()).append("S")));
                }

                // L
                int l = ((currValue * 10) >= 10000) ?
                        ((currValue * 10) - (currValue / 1000) * 10000) + (currValue / 1000) : currValue * 10;
                if (!visited[l]) {
                    visited[l] = true;
                    q.add(new Node(l, new StringBuilder(currSb.toString()).append("L")));
                }
                // R
                int r = ((currValue / 10) == 0) ?
                        (currValue % 10) * 1000 : ((currValue / 10) + ((currValue % 10) * 1000));
                if (!visited[r]) {
                    visited[r] = true;
                    q.add(new Node(r, new StringBuilder(currSb.toString()).append("R")));
                }
            }
            answerList.append(answer).append("\n");
        }
        System.out.println(answerList);
    }

    static class Node {
        int value;
        StringBuilder sb;

        Node(int value, StringBuilder sb) {
            this.value = value;
            this.sb = sb;
        }
    }
}