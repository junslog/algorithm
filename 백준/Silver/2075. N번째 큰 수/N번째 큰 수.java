import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> pq = new PriorityQueue<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    // N개의 값을 넣어놓는다.
    for (int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int currValue = Integer.parseInt(st.nextToken());
        if (currValue < pq.peek()) {
          continue;
        }
        pq.add(currValue);
        pq.poll();
      }
    }
    System.out.println(pq.poll());
  }

}