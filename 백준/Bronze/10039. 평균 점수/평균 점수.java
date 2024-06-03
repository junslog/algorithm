import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 5;
        int sum = 0;
        while(count-- > 0){
            int score = Integer.parseInt(br.readLine());
            sum += ((score > 40)? score : 40);
        }
        System.out.println(sum / 5);
    }
}