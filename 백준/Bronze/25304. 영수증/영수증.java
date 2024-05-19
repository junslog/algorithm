import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            totalPrice -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        System.out.println(totalPrice == 0 ? "Yes" : "No");
    }
}