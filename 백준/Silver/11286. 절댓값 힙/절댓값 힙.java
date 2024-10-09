import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Number> q = new PriorityQueue<>();
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        Number poll = q.poll();
        if (poll == null) {
          sb.append(0).append("\n");
        } else {
          sb.append(poll.x).append("\n");
        }
      } else {
        q.add(new Number(input));
      }
    }
    System.out.println(sb);
  }

  static class Number implements Comparable<Number> {

    int x;

    Number(int x) {
      this.x = x;
    }

    @Override
    public int compareTo(Number other) {
      int xUltimate = Math.abs(x);
      int otherUltimate = Math.abs(other.x);
      if (xUltimate != otherUltimate) {
        return Integer.compare(xUltimate, otherUltimate);
      }
      return Integer.compare(x, other.x);
    }

  }
}