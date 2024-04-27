import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!(input = br.readLine()).equals("0 0")) {
            String[] convert = input.split(" ");
            int A = Integer.parseInt(convert[0]);
            int B = Integer.parseInt(convert[1]);
            System.out.println(A > B ? "Yes" : "No");
        }
    }
}