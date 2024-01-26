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

        for(int i = 0; i < tcNum; i++){

            st = new StringTokenizer(br.readLine());
            int numOfNums = Integer.parseInt(st.nextToken());
            int[] numbers = new int[numOfNums];
            for(int j = 0; j < numOfNums; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            long sumOfGCD = 0;
            for(int j = 0; j < numbers.length; j++){
                for(int k = j ; k < numbers.length; k++){
                    if(j==k){
                        continue;
                    }
                    sumOfGCD += gcd(numbers[j], numbers[k]);
                }
            }
            sb.append(sumOfGCD).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}