import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] pHeight;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    pHeight = new int[1001];
    int leftIdx = Integer.MAX_VALUE, midIdx = -1, rightIdx = Integer.MIN_VALUE;
    int maxHeight = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      leftIdx = Math.min(leftIdx, idx);
      rightIdx = Math.max(rightIdx, idx);
      int height = Integer.parseInt(st.nextToken());
      if (height > maxHeight) {
        maxHeight = height;
        midIdx = idx;
      }
      pHeight[idx] = height;
    }

    int sum = 0;

    // 1. left -> mid
    int leftHeight = pHeight[leftIdx];
    for (int i = leftIdx; i < midIdx; i++) {
      if (leftHeight >= pHeight[i]) {
        sum += leftHeight;
      } else {
        sum += pHeight[i];
        leftHeight = pHeight[i];
      }
    }

    // 2. right -> mid
    int rightHeight = pHeight[rightIdx];
    for (int i = rightIdx; i > midIdx; i--) {
      if (rightHeight >= pHeight[i]) {
        sum += rightHeight;
      } else {
        sum += pHeight[i];
        rightHeight = pHeight[i];
      }
    }

    // 3. + pHeight[midIdx]
    sum += pHeight[midIdx];

    System.out.println(sum);
  }

}