import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int coinCount = 0;
        while (K != 0) {
            int plusCoin = 0;
            int currCoinValue = 0;
            for (int i = 0; i < N; i++) {
                if (coins[i] <= K) {
                    plusCoin = K / coins[i];
                    currCoinValue = coins[i];
                } else {
                    break;
                }
            }
            K -= plusCoin * currCoinValue;
            coinCount += plusCoin;
        }
        System.out.println(coinCount);
    }
}