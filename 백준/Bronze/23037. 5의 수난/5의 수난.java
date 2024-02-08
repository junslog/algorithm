import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split("");
        int[] vals = new int[5];
        for(int i = 0; i < 5; i++){
            vals[i] = Integer.parseInt(values[i]);
        }
        int result = 0;
        for(int i = 0; i < 5; i++){
            result += getFivePowerFive(vals[i]);
        }
        System.out.println(result);
    }

    public static int getFivePowerFive(int N){
        return N*N*N*N*N;
    }
}