import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long numOfTwos = 0;
        long numOfFives = 0;
        // 2의 개수 세기
        numOfTwos = twoPowerN(N) - twoPowerN(N-M) - twoPowerN(M);
        // 5의 개수 세기
        numOfFives = fivePowerN(N) - fivePowerN(N-M) - fivePowerN(M);

        System.out.println(Math.min(numOfTwos, numOfFives));
        br.close();
    }

    public static long fivePowerN(long input){
        long count = 0;
        while(input >= 5){
            count += input / 5;
            input /= 5;
        }
        return count;
    }

    public static long twoPowerN(long input){
        long count = 0;
        while(input >= 2){
            count += input / 2;
            input /= 2;
        }
        return count;
    }
}