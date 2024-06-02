import java.io.*;
import java.util.StringTokenizer;

class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if(a*b <= c){
            System.out.println(0);
        } else {
            System.out.println(a*b-c);
        }
    }
}