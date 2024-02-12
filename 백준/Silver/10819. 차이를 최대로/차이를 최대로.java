import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] input;
    static int[] items;
    static boolean[] check;
    static int N;
    static int maximum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        items = new int[N];
        check = new boolean[N];
        backtracking(0);
        System.out.println(maximum);
    }

    public static void backtracking(int depth){
        if(depth == N){
            int result = findGap();
            if(maximum < result){
                maximum = result;
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            items[depth] = input[i];
            backtracking(depth+1);
            check[i] = false;
        }
    }

    public static int findGap(){
        int sum = 0;
        for(int i = 0; i <= N-2; i++){
            sum += Math.abs(items[i+1] - items[i]);
        }
        return sum;
    }
}