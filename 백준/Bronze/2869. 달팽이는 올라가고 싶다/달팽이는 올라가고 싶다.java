import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int ABGap = A - B;
        int startDay = (V - A) / ABGap;
        int startHeight = ABGap * startDay;
        while (startHeight < V) {
            startDay++;
            startHeight += A;
            if (startHeight >= V) {
                break;
            }
            startHeight -= B;
        }
        System.out.println(startDay);
    }
}