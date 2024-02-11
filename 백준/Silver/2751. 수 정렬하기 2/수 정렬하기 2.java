import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] checkNegative = new boolean[1000001];
        boolean[] checkPositive = new boolean[1000001];
        for(int i = 0; i < N; i++){
            int idx = Integer.parseInt(br.readLine());
            if(idx < 0){
                checkNegative[-idx] = true;
            } else {
                checkPositive[idx] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1000000; i > 0; i--){
            if(checkNegative[i]){
                sb.append(-i).append("\n");
            }
        }
        for(int i = 0; i <= 1000000; i++){
            if(checkPositive[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}