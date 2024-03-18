import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fiveCnt = N / 5;
        int threeCnt = 0;
        while (fiveCnt >= 0) {
            int curFiveVal = fiveCnt * 5;
            if ((N - curFiveVal) % 3 == 0) {
                threeCnt = (N - curFiveVal) / 3;
                break;
            }
            fiveCnt -= 1;
        }
        if (fiveCnt < 0) {
            System.out.println(-1);
        } else {
            System.out.println(fiveCnt + threeCnt);
        }
    }
}