import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] items;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        items = new int[M];
        backtracking(0);
        System.out.println(sb);
        br.close();
    }

    public static void backtracking(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            items[depth] = i;
            backtracking(depth+1);
        }
    }
}