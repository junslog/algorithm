import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        items = new int[N];
        backtracking(0);
        System.out.println(sb);
        br.close();
    }

    public static void backtracking(int depth){
        if(depth == N){
            for(int i = 0; i < N; i++){
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(check[i]){
                continue;
            }
            items[depth] = i; check[i] = true;
            backtracking(depth+1);
            check[i] = false;
        }
    }
}