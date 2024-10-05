import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Node>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V];
    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }

    int base = Integer.parseInt(br.readLine()) - 1;

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      int weight = Integer.parseInt(st.nextToken());
      graph[start].add(new Node(end, weight));
    }

    int[] dp = new int[V];
    for (int i = 0; i < V; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[base] = 0;

    PriorityQueue<Node> q = new PriorityQueue<>();
    q.add(new Node(base, 0));
    while (!q.isEmpty()) {
      Node curr = q.poll();
      List<Node> nodes = graph[curr.num];
      for (Node e : nodes) {
        int currNum = curr.num;
        int end = e.num;
        int weight = e.weight;
        if (dp[end] > dp[currNum] + weight) {
          dp[end] = dp[currNum] + weight;
          q.add(new Node(end, dp[end]));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int v : dp) {
      if (v == Integer.MAX_VALUE) {
        sb.append("INF").append("\n");
      } else {
        sb.append(v).append("\n");
      }
    }
    System.out.println(sb);
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
      return this.weight - other.weight;
    }
  }

}