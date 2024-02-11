import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0")){
            StringBuilder inputReverse = new StringBuilder();
            char[] inputChars = input.toCharArray();
            for(int i = inputChars.length -1; i >= 0; i--){
                inputReverse.append(inputChars[i]);
            }
            if(inputReverse.toString().equals(input)){
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}