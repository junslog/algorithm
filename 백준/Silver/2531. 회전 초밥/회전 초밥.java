import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int d;
  static int k;
  static int c;

  static int[] sushies;
  static boolean[] dCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    sushies = new int[N];
    for (int i = 0; i < N; i++) {
      sushies[i] = Integer.parseInt(br.readLine());
    }

    dCount = new boolean[d + 1];
    int maxCnt = 0;
    for (int start = 0; start < N; start++) {
      int runner = 0;
      for (int j = start; runner < k; j = (j + 1) % N, runner++) {
        dCount[sushies[j]] = true;
      }
      maxCnt = Math.max(maxCnt, countVariety());
      refreshDCount();
    }
    System.out.println(maxCnt);
  }

  private static int countVariety() {
    int cnt = 0;
    for (boolean isChecked : dCount) {
      if (isChecked) {
        cnt++;
      }
    }
    if (!dCount[c]) {
      cnt++;
    }
    return cnt;
  }

  private static void refreshDCount() {
    for (int i = 0; i <= d; i++) {
      dCount[i] = false;
    }
  }

}