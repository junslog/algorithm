import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, new ArrayList<>());
        System.out.println(max);
    }

    public static void backtracking(int index, List<Integer> prices){
        if(index >= N){
            int sum = 0;
            for(int i = 0; i < prices.size(); i++){
                sum += prices.get(i);
            }
            if(max < sum){
                max = sum;
            }
            return;
        }

        for(int i = index; i < N; i++){
            if(i + T[i] <= N) {
                List<Integer> pCopy1 = new ArrayList<>(prices);
                pCopy1.add(P[i]);
                backtracking(i + T[i], pCopy1);
            }
            List<Integer> pCopy2 = new ArrayList<>(prices);
            backtracking(i + 1, pCopy2);
        }
    }
}