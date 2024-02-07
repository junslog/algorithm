import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[] check;
    static int[] items;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        items = new int[M+1];
        permutation(0);
    }

    public static void permutation(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int item : items){
                if(item == 0){
                    break;
                }
                sb.append(item).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++){
            if(check[i]){
                continue;
            }
            check[i] = true; items[depth] = i;
            permutation(depth+1);
            check[i] = false;
        }
    }
}