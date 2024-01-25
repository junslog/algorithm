import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Initialize
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // Sieve of Erathosthenes
        boolean[] check = new boolean[N+1];
        int[] pNumbers = new int[N];
        int pN = 0;
        for(int i = 2; i <= N; i++){
            if(!check[i]){
                pNumbers[pN++] = i;
                for(int j = i * 2; j <= N; j+=i){
                    check[j] = true;
                }
            }
        }

        // M 이상인 값들만 거르기
        for(int i = 0; i < pNumbers.length; i++){
            if(pNumbers[i] >= M){
                System.out.println(pNumbers[i]);
            }
        }
        br.close();
    }
}