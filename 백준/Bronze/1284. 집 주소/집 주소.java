import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] point = new int[10];
        point[0] = 4;
        point[1] = 2;
        for (int i = 2; i <= 9; i++) {
            point[i] = 3;
        }
        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("0")) {
            int p = 0;
            for (char c : input.toCharArray()) {
                p += ((point[c - '0']) + 1);
            }
            sb.append(p + 1).append("\n");
        }
        System.out.println(sb);
    }
}