import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    long[] lans = new long[K];
    long min = 1L;
    long max = Long.MIN_VALUE;
    for (int i = 0; i < K; i++) {
      lans[i] = Long.parseLong(br.readLine());
      max = Math.max(lans[i], max);
    }
    max += 1;

    while (min < max) {
      long mid = (min + max) / 2;
      long count = 0L;
      for (long l : lans) {
        count += (l / mid);
      }

      if (count >= N) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    System.out.println(min - 1);
  }
}