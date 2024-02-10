import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] input;
    static int[] items;
    static Set<String> remember;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i =0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        items = new int[M];
        remember = new HashSet<>();
        backtracking(0);
        System.out.println(sb);
        br.close();
    }

    public static void backtracking(int depth){
        if(depth == M) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++){
                temp.append(items[i]).append(" ");
            }
            temp.append("\n");
            String tempVal = temp.toString();
            if (!isRemembered(tempVal)) {
                remember.add(tempVal);
                sb.append(tempVal);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            items[depth] = input[i];
            backtracking(depth+1);
        }
    }

    public static boolean isRemembered(String item){
        return remember.contains(item);
    }
}