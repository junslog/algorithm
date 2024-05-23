import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        while(count-- > 0){
            int inputLen = br.readLine().length();
            if(inputLen < 6 || inputLen > 9){
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}