import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

  static int[] paperCount = new int[3]; // 각 idx 0,1,2 당 -1, 0, 1 을 담는 배열
  static int[][] matrix;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    matrix = new int[N + 1][N + 1];
    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    calculatePaperCount(1, 1, N);
    for (int i = 0; i < 3; i++) {
      System.out.println(paperCount[i]);
    }
  }

  private static void calculatePaperCount(int startX, int startY, int size) {
    int currValue = matrix[startX][startY];
    if (size == 1) {
      paperCount[currValue + 1]++;
      return;
    }

    boolean shouldDivide = false;
    for (int i = startX; i < startX + size; i++) {
      for (int j = startY; j < startY + size; j++) {
        if (matrix[i][j] != currValue) {
          shouldDivide = true;
          break;
        }
      }
    }

    if (shouldDivide) {
      int newSize = size / 3;
      for (int x = startX; x < startX + size; x += newSize) {
        for (int y = startY; y < startY + size; y += newSize) {
          calculatePaperCount(x, y, newSize);
        }
      }
    } else {
      paperCount[currValue + 1]++;
    }
  }
}