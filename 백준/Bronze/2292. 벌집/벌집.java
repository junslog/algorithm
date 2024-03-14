import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int currPos = 1;
        int runner = 0;
        while (true) {
            int dist = 6 * runner;
            currPos += dist;
            runner++;
            if (currPos >= N) {
                System.out.println(runner);
                break;
            }
        }

    }
}