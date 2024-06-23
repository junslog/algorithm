import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int h, w;
  static int[] heights;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    heights = new int[w];
    for (int i = 0; i < w; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    int rainWater = 0;
    for (int i = 1; i < w - 1; i++) {
      int curr = heights[i];
      int lMax = findLeftMax(i);
      int rMax = findRightMax(i);

      if (lMax > curr && rMax > curr) {
        rainWater += (Math.min(lMax, rMax) - curr);
      }
    }

    System.out.println(rainWater);

  }

  private static int findLeftMax(int currIdx) {
    int max = heights[currIdx - 1];
    for (int i = currIdx - 1; i >= 0; i--) {
      if (heights[i] > max) {
        max = heights[i];
      }
    }
    return max;
  }

  private static int findRightMax(int currIdx) {
    int max = heights[currIdx + 1];
    for (int i = currIdx + 1; i <= w - 1; i++) {
      if (heights[i] > max) {
        max = heights[i];
      }
    }
    return max;
  }

}