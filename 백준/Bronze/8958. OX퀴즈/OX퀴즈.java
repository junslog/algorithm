import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();
            int cumulative = 0;
            int sum = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'O') {
                    cumulative++;
                    sum += cumulative;
                }
                if (input[i] == 'X') {
                    cumulative = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}