import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int first = 666;
        int count = 1;
        while(true){
            first++;
            if(String.valueOf(first).contains("666")){
                count++;
            }
            if(count == N){
                break;
            }
        }
        if(N == 1){
            System.out.print(first - 1);
        } else {
            System.out.print(first);
        }
        br.close();
    }
}
