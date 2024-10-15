import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int aCnt = 0, bCnt = 0;
    for (char c : input.toCharArray()) {
      if (c == 'a') {
        aCnt++;
      } else if (c == 'b') {
        bCnt++;
      }
    }
    int minCnt = 100_000;
    int inputLen = input.length();
    for (int start = 0; start < inputLen; start++) {
      int runner = 0;
      int bCount = 0;
      while (runner < aCnt) {
        int idx = (start + runner) % inputLen;
        if (input.charAt(idx) == 'b') {
          bCount++;
        }
        runner++;
      }
      minCnt = Math.min(minCnt, bCount);
    }
    System.out.println(minCnt);
  }
}