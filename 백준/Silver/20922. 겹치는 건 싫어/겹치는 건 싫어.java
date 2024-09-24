import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int l = 0, r = 0;
    int maxLen = 0;
    int[] count = new int[100_001];
    while (r < arr.length) {
      while (count[arr[r]] >= K && l < arr.length) {
        count[arr[l]]--;
        l++;
      }
      count[arr[r]]++;
      r++;
      maxLen = Math.max(maxLen, r - l);
    }
    System.out.println(maxLen);
  }
}