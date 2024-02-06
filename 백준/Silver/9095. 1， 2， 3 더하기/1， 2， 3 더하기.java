import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int methodCount;
    
    // 1,2,3 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            dfs(N);
            sb.append(methodCount).append("\n");
            methodCount = 0;
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int N){
        if(N == 1){
            methodCount++;
            return;
        }
        if(N == 2){
            methodCount+=2;
            return;
        }
        if(N == 3){
            methodCount+=4;
            return;
        }
        for(int i = 1; i <= 3; i++){
            dfs(N-i);
        }
    }
}