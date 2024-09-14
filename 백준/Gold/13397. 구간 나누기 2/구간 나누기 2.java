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
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];

    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      minValue = Math.min(arr[i], minValue);
      maxValue = Math.max(arr[i], maxValue);
    }
    int arrLen = arr.length;
    int minGap = 0;
    int highGap = maxValue - minValue;
    while (minGap <= highGap) {
      int midGap = (minGap + highGap) / 2;
      int mCount = 1;
      int minV = Integer.MAX_VALUE;
      int maxV = Integer.MIN_VALUE;
      for (int i = 0; i < arrLen; i++) {
        minV = Math.min(arr[i], minV);
        maxV = Math.max(arr[i], maxV);
        if (maxV - minV > midGap) {
          mCount++;
          minV = arr[i];
          maxV = arr[i];
        }
      }
      if (mCount > M) {
        minGap = midGap + 1;
      } else {
        highGap = midGap - 1;
      }
    }
    System.out.println(highGap + 1);
    br.close();
  }
}