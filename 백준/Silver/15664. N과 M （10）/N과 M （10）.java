import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] input;
    static int[] items;
    static List<int[]> remember;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        items = new int[M];
        remember = new ArrayList<>();
        backtracking(0,0);
        System.out.println(sb);
        br.close();
    }

    public static void backtracking(int depth, int startIdx){
        if(depth == M){
            if(isRemembered()){
                return;
            }
            for(int i = 0; i < M; i++){
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            int[] newRememberItem = new int[M];
            for(int i = 0; i < M; i++){
                newRememberItem[i] = items[i];
            }
            remember.add(newRememberItem);
            return;
        }

        for(int i = startIdx; i < N; i++){
            items[depth] = input[i];
            backtracking(depth+1, i+1);
        }
    }

    public static boolean isRemembered(){
        for(int i = 0; i < remember.size(); i++){
            int[] rememberEntry = remember.get(i);
            if(isSame(items, rememberEntry)){
                return true;
            }
        }
        return false;
    }

    public static boolean isSame(int[] items, int[] rememberEntry){
        for(int i = 0; i < M; i++){
            if(items[i] != rememberEntry[i]){
                return false;
            }
        }
        return true;
    }
}