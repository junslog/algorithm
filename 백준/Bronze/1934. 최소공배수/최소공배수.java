import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int A, B;
        for(int i = 0; i < tcNum; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(A*B/gcd(A,B)).append("\n");
        }
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