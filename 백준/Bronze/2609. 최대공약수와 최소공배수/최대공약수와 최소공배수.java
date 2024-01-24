import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int gcd = gcd(A,B);
        sb.append(gcd).append("\n")
                .append(A*B/gcd);
        System.out.println(sb);

        br.close();
    }

    public static int gcd(int A, int B){
        if(B == 0){
            return A;
        }
        return gcd(B, A%B);
    }
}