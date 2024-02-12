import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] inputItems;
    static int[] items = new int[6];
    static int k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        while(!(input = br.readLine()).equals("0")){
            st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            inputItems = new int[k];
            for(int i = 0; i < k; i++){
                inputItems[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void backtracking(int depth, int startIdx){
        if(depth == 6){
            for(int i = 0; i < 6; i ++){
                sb.append(items[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = startIdx; i < k; i++){
            items[depth] = inputItems[i];
            backtracking(depth+1, i+1);
        }
    }
}