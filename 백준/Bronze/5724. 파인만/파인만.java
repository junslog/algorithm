import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N;
        while (!(N = br.readLine()).equals("0")) {
            int k = Integer.parseInt(N);
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += i * i;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}