import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] input;
    static int[] items;
    static StringBuilder sb = new StringBuilder();
    static Set<String> remember = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        items = new int[M];
        backtracking(0,0);
        System.out.println(sb);
    }

    public static void backtracking(int depth, int startIdx){
        if(depth == M){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++){
                temp.append(items[i]).append(" ");
            }
            String tempVal = temp.toString();
            if(!remember.contains(tempVal)){
                remember.add(tempVal);
                sb.append(tempVal).append("\n");
            }
            return;
        }

        for(int i = startIdx; i < N; i++){
            items[depth] = input[i];
            backtracking(depth+1, i);
        }
    }
}