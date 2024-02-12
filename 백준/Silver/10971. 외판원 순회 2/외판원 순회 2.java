import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int startCity;
    static int N;
    static int[][] W;
    static int minimumCost = 1000000000;
    static int[] cost;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        cost = new int[N+2];
        check = new boolean[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        traverse(0,-1);
        System.out.println(minimumCost);
    }

    public static void traverse(int depth, int currCity){
        if(depth == N){
            int c = W[currCity][startCity];
            if(c == 0){
                return;
            }
            cost[depth-1] = c;
            int sum = 0;
            for(int cs : cost){
                sum += cs;
            }
            if(sum < minimumCost){
                minimumCost = sum;
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(depth == 0){
                startCity = i;
            } else {
                if(check[i]){
                    continue;
                }
                int c = W[currCity][i];
                if(c == 0){
                    return;
                }
                cost[depth-1] = c;
            }
            check[i] = true;
            traverse(depth+1, i);
            check[i] = false;
        }
    }
}