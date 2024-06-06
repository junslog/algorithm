import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String answer = null;
        while(N-- > 0){
            if((answer = br.readLine()).contains("S")){
                break;
            }
        }
        System.out.println(answer);
    }
}