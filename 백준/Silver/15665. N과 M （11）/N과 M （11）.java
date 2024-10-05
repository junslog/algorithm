import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int[] items;
  static int[] choices;
  static int itemsLen;
  static int N, M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    Map<Integer, Boolean> exist = new HashMap<>();
    for (int i = 0; i < N; i++) {
      exist.put(Integer.parseInt(st.nextToken()), true);
    }
    int size = exist.keySet().size();
    items = new int[size];
    int runner = 0;
    for (int k : exist.keySet()) {
      items[runner++] = k;
    }
    Arrays.sort(items);
    itemsLen = items.length;
    choices = new int[M];
    backtracking(0);
    System.out.println(sb);
  }

  private static void backtracking(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(choices[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < itemsLen; i++) {
      choices[depth] = items[i];
      backtracking(depth + 1);
    }
  }
}