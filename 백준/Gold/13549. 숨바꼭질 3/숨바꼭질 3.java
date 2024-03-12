import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        Node subin = new Node(N, 0);
        q.add(subin);
        boolean reached = false;
        Node minReach = new Node(-1, -1);
        while (!q.isEmpty()) {
            Node elem = q.poll();
            
            if (visited.getOrDefault(elem.value, -1) == -1) {
                visited.put(elem.value, elem.time);
            } else if (visited.get(elem.value) > elem.time) {
                visited.put(elem.value, elem.time);
            } else {
                continue;
            }
            
            if (reached) {
                if (minReach.time <= elem.time) {
                    continue;
                }
                if (minReach.value == elem.value) {
                    minReach = elem;
                }
            } else {
                if (elem.value == K) {
                    reached = true;
                    minReach = elem;
                    continue;
                }
                if (elem.value == 0) {
                    q.add(new Node(elem.value + 1, elem.time + 1));
                } else if (elem.value >= 50001) {
                    q.add(new Node(elem.value + 1, elem.time + 1));
                    q.add(new Node(elem.value - 1, elem.time + 1));
                } else {
                    q.add(new Node(elem.value + 1, elem.time + 1));
                    q.add(new Node(elem.value - 1, elem.time + 1));
                    q.add(new Node(elem.value * 2, elem.time));
                }
            }
        }
        System.out.println(minReach.time);
        br.close();
    }

    public static class Node {
        int value;
        int time;

        Node(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}