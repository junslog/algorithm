import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(br.readLine());
        Map<Long, Boolean> visited = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(input, 0));
        boolean found = false;
        long minOp = 9999999999999999L;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (found) {
                if (curr.op >= minOp) {
                    continue;
                }
            }
            long currVal = curr.value;
            if (currVal == 1) {
                found = true;
                minOp = curr.op;
            }
            long currOp = curr.op;
            if (currVal % 3 == 0) {
                if (!visited.getOrDefault(currVal / 3, false)) {
                    visited.put(currVal, true);
                    q.add(new Node(currVal / 3, currOp + 1));
                }
            }
            if (currVal % 2 == 0) {
                if (!visited.getOrDefault(currVal / 2, false)) {
                    visited.put(currVal / 2, true);
                    q.add(new Node(currVal / 2, currOp + 1));
                }
            }
            if (currVal - 1 > 1) {
                if (!visited.getOrDefault(currVal - 1, false)) {
                    visited.put(currVal - 1, true);
                    q.add(new Node(currVal - 1, currOp + 1));
                }
            }
        }
        System.out.println(minOp);
    }

    public static class Node {
        long value;
        long op;

        Node(long value, long op) {
            this.value = value;
            this.op = op;
        }
    }
}