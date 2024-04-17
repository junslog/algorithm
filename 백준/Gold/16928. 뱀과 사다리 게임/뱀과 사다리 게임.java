import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[101];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        visited[1] = true;
        Set<Integer> ladderStartPoints = ladders.keySet();
        Set<Integer> snakeStartPoints = snakes.keySet();
        int roll = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 1; i <= 6; i++) {
                int elem = node.position;
                int currStep = node.step;
                if (visited[elem + i] || elem + i > 100) {
                    continue;
                }
                visited[elem + i] = true;
                if (elem + i == 100) {
                    roll = currStep + 1;
                    q.clear();
                    break;
                }
                if (ladderStartPoints.contains(elem + i)) {
                    int ladderEndPoint = ladders.get(elem + i);
                    visited[ladderEndPoint] = true;
                    q.add(new Node(ladderEndPoint, currStep + 1));
                    continue;
                }
                if (snakeStartPoints.contains(elem + i)) {
                    int snakeEndPoint = snakes.get(elem + i);
                    visited[snakeEndPoint] = true;
                    q.add(new Node(snakeEndPoint, currStep + 1));
                    continue;
                }
                q.add(new Node(elem + i, currStep + 1));
            }
        }
        System.out.println(roll);
    }

    public static class Node {
        int position;
        int step;

        Node(int position, int step) {
            this.position = position;
            this.step = step;
        }
    }
}