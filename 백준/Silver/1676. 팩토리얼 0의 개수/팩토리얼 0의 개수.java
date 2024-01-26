import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int numOfZeros = 0;
        for(int i = 5; i <= N; i = i * 5){
            numOfZeros += (int) Math.floor((double) N / i);
        }
        System.out.println(numOfZeros);
    }
}