import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfNums = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfPNs = 0;
        int givenNum;
        for(int i = 0; i < numOfNums; i++){
            givenNum = Integer.parseInt(st.nextToken());
            if(isPrimeNumber(givenNum)){
                numOfPNs++;
            }
        }
        System.out.println(numOfPNs);
        br.close();
    }

    public static boolean isPrimeNumber(int N){
        if( N < 2 ){
            return false;
        }
        for(int i = 2; i*i <= N; i++) {
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }
}