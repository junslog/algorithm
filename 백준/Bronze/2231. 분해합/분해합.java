import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int[] eachDigitValue = new int[7];
        int result = 0;
        while(start++ < N){
            String[] values = String.valueOf(start).split("");
            for(int i = 0; i < values.length; i++){
                eachDigitValue[i] = Integer.parseInt(values[i]);
            }
            int sum = 0;
            for(int i = 0; i < values.length; i++){
                sum += eachDigitValue[i];
            }
            if(start + sum == N){
                result = start;
                break;
            }
        }
        System.out.println(result);
        br.close();
    }
}