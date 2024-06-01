import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int runner = 4;
    while (runner-- > 0) {
      sum += Integer.parseInt(br.readLine());
    }
    int bun = sum / 60;
    int cho = sum - bun * 60;
    System.out.println(bun);
    System.out.println(cho);
  }

}