import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (N-- > 0) {
      char[] input = br.readLine().toCharArray();
      boolean[] check = new boolean['Z' - 'A' + 1];
      for (char c : input) {
        check[(c - 'A')] = true;
      }
      int sum = 0;
      int runner = 0;
      for (boolean b : check) {
        if (!b) {
          sum += ('A' + runner);
        }
        runner++;
      }
      sb.append(sum).append("\n");
    }
    System.out.println(sb);
  }

}