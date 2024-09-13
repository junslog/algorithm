import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int[] houses = new int[N];
    for (int i = 0; i < N; i++) {
      houses[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(houses);

    int lowDist = 1;
    int maxDist = houses[N - 1] - houses[0];
    while (lowDist <= maxDist) {
      int wifiCnt = 1;
      int prev = houses[0];
      int midDist = (lowDist + maxDist) / 2;
      for (int i = 1; i < N; i++) {
        int distDiff = houses[i] - prev;
        if (distDiff >= midDist) {
          prev = houses[i];
          wifiCnt++;
        }
      }
      if (wifiCnt >= C) {
        lowDist = midDist + 1;
      } else {
        maxDist = midDist - 1;
      }
    }
    System.out.println(lowDist - 1);
  }
}