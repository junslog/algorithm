import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String[] rString = st.nextToken().split("");
            for(int j = 0; j < rString.length; j++){
                for(int k = 0; k < repeat; k++){
                    sb.append(rString[j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}