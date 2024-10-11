import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {

      String input = br.readLine();
      int K = Integer.parseInt(br.readLine());

      int[] alpha = new int['z' - 'a' + 1];
      for (int j = 0; j < input.length(); j++) {
        alpha[input.charAt(j) - 'a']++;
      }

      int min = Integer.MAX_VALUE;
      int max = -1;

      if (K == 1) {
        sb.append("1 1").append("\n");
        continue;
      }

      for (int j = 0; j < input.length(); j++) {
        if (alpha[input.charAt(j) - 'a'] < K) {
          continue;
        }
        int count = 1;

        for (int k = j + 1; k < input.length(); k++) {
          if (input.charAt(j) == input.charAt(k)) {
            count++;
          }

          if (count == K) {
            min = Math.min(min, k - j + 1);
            max = Math.max(max, k - j + 1);
            break;
          }
        }
      }

      if (min == Integer.MAX_VALUE || max == -1) {
        sb.append("-1").append("\n");
        continue;
      }
      sb.append(min).append(" ").append(max).append("\n");
    }
    System.out.println(sb);
  }
}