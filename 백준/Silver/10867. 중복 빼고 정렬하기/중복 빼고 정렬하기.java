import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] numbers = new boolean[2001];
        int zero = 1000;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (N-- > 0) {
            numbers[zero + Integer.parseInt(st.nextToken())] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2001; i++) {
            if (numbers[i]) {
                sb.append(i - zero).append(" ");
            }
        }
        System.out.println(sb);
    }
}