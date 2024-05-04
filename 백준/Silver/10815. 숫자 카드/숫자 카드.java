import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] range = new boolean[10000000 * 2 + 1];
        String[] exist = br.readLine().split(" ");
        int zeroBase = 10000000;
        for (String e : exist) {
            range[zeroBase + Integer.parseInt(e)] = true;
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] vals = br.readLine().split(" ");
        for (String val : vals) {
            if (range[zeroBase + Integer.parseInt(val)]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}