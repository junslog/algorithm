import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] length = new int[N];
        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (max < length[i]) {
                max = length[i];
            }
        }
        System.out.println(max);
    }
}