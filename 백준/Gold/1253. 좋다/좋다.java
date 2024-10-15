import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    Arrays.sort(input);
    int goodCnt = 0;
    for (int i = 0; i < N; i++) {
      int target = input[i];
      int left = 0, right = input.length - 1;
      while (left < right) {

        if (i == left) {
          left++;
          continue;
        } else if (i == right) {
          right--;
          continue;
        }

        int sum = input[left] + input[right];

        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          goodCnt++;
          break;
        }
      }
    }
    System.out.println(goodCnt);
  }
}