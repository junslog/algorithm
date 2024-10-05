import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] height = new long[N];
    st = new StringTokenizer(br.readLine());
    long maxHeight = Long.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      height[i] = Integer.parseInt(st.nextToken());
      maxHeight = Math.max(maxHeight, height[i]);
    }
    long left = 0L;
    long right = maxHeight;
    while (left < right) {
      long mid = (left + right) / 2;
      long sum = 0L;
      for (int i = 0; i < N; i++) {
        sum += (height[i] > mid ? height[i] - mid : 0);
      }
      if (sum >= M) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    System.out.println(left - 1);
  }

}