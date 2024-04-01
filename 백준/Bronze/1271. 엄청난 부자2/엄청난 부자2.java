import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger source = new BigInteger(st.nextToken());
        BigInteger divide = new BigInteger(st.nextToken());
        BigInteger money = source.divide(divide);
        BigInteger remainder = source.mod(divide);
        System.out.println(money);
        System.out.println(remainder);
    }
}