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
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[1000001];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(S, 0));
        visited[S] = true;
        int minOp = 999999999;
        boolean found = false;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currFloor = curr.floor;
            int currOp = curr.numOfElevOp;
            if (currFloor == G) {
                found = true;
                if (minOp > currOp) {
                    minOp = currOp;
                }
            }
            if (currFloor + U <= F && !visited[currFloor + U]) {
                visited[currFloor + U] = true;
                q.add(new Node(currFloor + U, currOp + 1));
            }
            if (currFloor - D >= 1 && !visited[currFloor - D]) {
                visited[currFloor - D] = true;
                q.add(new Node(currFloor - D, currOp + 1));
            }
        }

        if (found) {
            System.out.println(minOp);
        } else {
            System.out.println("use the stairs");
        }
    }

    public static class Node {
        int floor;
        int numOfElevOp;

        Node(int floor, int numOfElevOp) {
            this.floor = floor;
            this.numOfElevOp = numOfElevOp;
        }
    }
}