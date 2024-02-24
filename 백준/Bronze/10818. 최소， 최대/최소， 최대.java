import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = -1000000000;
        int min = 1000000000;

        int input;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(st.nextToken());
            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }
        }
        System.out.println(min + " " + max);
    }
}