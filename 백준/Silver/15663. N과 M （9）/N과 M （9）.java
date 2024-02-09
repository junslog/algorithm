import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<int[]> remember = new ArrayList<>();
    static int[] input;
    static int[] items;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

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
        check = new boolean[N];
        backtracking(0);
        System.out.println(sb);
    }

    public static void backtracking(int depth){
        if(depth == M){
            if(isRemembered(items)){
                return;
            }
            for(int i = 0; i < M; i++){
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            int[] newItems = new int[M];
            for(int i = 0; i < M; i++){
                newItems[i] = items[i];
            }
            remember.add(newItems);
            return;
        }

        for(int i = 0; i < N; i++){
            if(check[i]){
                continue;
            }
            items[depth] = input[i];
            check[i] = true;
            backtracking(depth+1);
            check[i] = false;
        }
    }

    public static boolean isRemembered(int[] items){
        for(int i = 0; i < remember.size(); i++) {
            int[] rememberEntry = remember.get(i);
            if(isSame(rememberEntry, items)){
                return true;
            }
        }
        return false;
    }

    public static boolean isSame(int[] rememberEntry, int[] items){
        for(int i = 0; i < M; i++){
            if(rememberEntry[i] != items[i]){
                return false;
            }
        }
        return true;
    }
}