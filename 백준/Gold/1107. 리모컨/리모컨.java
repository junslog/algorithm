import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> availableNumbers;
    static int target;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());

        availableNumbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int M = Integer.parseInt(br.readLine());
        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                availableNumbers.remove(new Integer(st.nextToken()));
            }
        }
        count = Math.abs(target - 100);
        dfs(0,0);
        System.out.println(count);
    }

    public static void dfs(int idx, int click){
        for(int i = 0; i < 10; i++){
            if(availableNumbers.contains(i)){
                int newBtn = click * 10 + i;
                int cnt = Math.abs(target - newBtn) + String.valueOf(newBtn).length();
                count = Math.min(count, cnt);
                if(idx < 6){
                    dfs(idx+1, newBtn);
                }
            }
        }
    }
}