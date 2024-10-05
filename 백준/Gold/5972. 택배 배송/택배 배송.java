import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Node>[] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      int num = Integer.parseInt(st.nextToken()) - 1;
      int weight = Integer.parseInt(st.nextToken());
      graph[idx].add(new Node(num, weight));
      graph[num].add(new Node(idx, weight));
    }

    int[] dist = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[0] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node currNode = pq.poll();
      int currNum = currNode.num;
      List<Node> nodes = graph[currNum];
      for (Node n : nodes) {
        int toNum = n.num;
        int weight = n.weight;

        if (dist[toNum] > dist[currNum] + weight) {
          dist[toNum] = dist[currNum] + weight;
          pq.add(new Node(toNum, dist[toNum]));
        }
      }
    }

    System.out.println(dist[dist.length - 1]);

  }

  static class Node implements Comparable<Node> {

    int num;
    int weight;

    Node(int num, int weight) {
      this.num = num;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
      return Integer.compare(this.weight, other.weight);
    }
  }

}