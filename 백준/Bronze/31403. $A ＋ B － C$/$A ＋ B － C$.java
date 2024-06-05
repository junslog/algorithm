import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        System.out.println(toInt(A) + toInt(B) - toInt(C));
        System.out.println(toInt(A+B) - toInt(C));
    }
    
    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}