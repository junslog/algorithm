import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(A, 0));
        int minStep = -1;
        // 연산의 종류가 무조건 증가하는 것 밖에 없으니, 굳이 visited 배열이 필요가 없다.
        while (!q.isEmpty()) {
            Node curr = q.poll();
            long currValue = curr.value;
            int currStep = curr.step;
            if (currValue > B) {
                continue;
            }
            if (currValue == B) {
                minStep = currStep + 1;
                break;
            }
            q.add(new Node(currValue * 2, currStep + 1));
            q.add(new Node(currValue * 10 + 1, currStep + 1));
        }
        System.out.println(minStep);
    }

    static class Node {
        long value;
        int step;

        Node(long value, int step) {
            this.value = value;
            this.step = step;
        }
    }
}