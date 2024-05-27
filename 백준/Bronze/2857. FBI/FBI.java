import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int count = 1;
        int fbi = 0;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String curr = br.readLine();
            if (curr.contains("FBI")) {
                sb.append(count).append(" ");
                fbi++;
            }
            count++;
        }
        if (fbi == 0) {
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println(sb);
        }

    }
}