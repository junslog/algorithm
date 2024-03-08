import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int wholeMinutes = 60 * H + M;
        if (wholeMinutes < 45) {
            wholeMinutes += 24 * 60;
        }
        wholeMinutes -= 45;
        int newH = wholeMinutes / 60;
        int newM = wholeMinutes % 60;
        System.out.println(newH + " " + newM);
        br.close();
    }
}