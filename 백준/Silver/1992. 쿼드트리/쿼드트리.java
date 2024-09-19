import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] matrix;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      String[] s = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(s[j]);
      }
    }
    recursive(0, 0, N);
  }

  private static void recursive(int startX, int startY, int size) {
    if (size == 1) {
      System.out.print(matrix[startX][startY]);
      return;
    }

    int gap = size / 2;
    if (isAllSame(startX, startY, size)) {
      System.out.print(matrix[startX][startY]);
    } else {
      System.out.print("(");
      for (int i = startX; i < startX + size; i += gap) {
        for (int j = startY; j < startY + size; j += gap) {
          recursive(i, j, gap);
        }
      }
      System.out.print(")");
    }
  }

  private static boolean isAllSame(int startX, int startY, int size) {
    int value = matrix[startX][startY];
    for (int i = startX; i < startX + size; i++) {
      for (int j = startY; j < startY + size; j++) {
        if (value != matrix[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}