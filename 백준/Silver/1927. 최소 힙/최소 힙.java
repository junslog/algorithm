import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> q = new PriorityQueue<>();
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        Integer poll = q.poll();
        if (poll == null) {
          sb.append(0).append("\n");
        } else {
          sb.append(poll).append("\n");
        }
      } else {
        q.add(input);
      }
    }
    System.out.println(sb);
  }
}