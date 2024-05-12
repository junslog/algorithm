import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] values = br.readLine().toCharArray();

        if (values.length == 1) {
            System.out.println("NO");
        } else {
            boolean found = false;
            for (int splitIdx = 0; splitIdx < values.length; splitIdx++) {
                int a = 1, b = 1;
                for (int j = 0; j <= splitIdx; j++) {
                    a *= (values[j] - '0');
                }
                for (int j = splitIdx + 1; j < values.length; j++) {
                    b *= (values[j] - '0');
                }
                if (a == b) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}