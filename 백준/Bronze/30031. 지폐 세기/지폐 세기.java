import java.io.*;
import java.util.StringTokenizer;

class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String val;
        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            val = st.nextToken();
            if(val.equals("136")){
                sum += 1000;
            } else if(val.equals("142")){
                sum += 5000;
            } else if(val.equals("148")){
                sum += 10000;
            } else if(val.equals("154")){
                sum += 50000;
            }
        }
        System.out.println(sum);
    }
}