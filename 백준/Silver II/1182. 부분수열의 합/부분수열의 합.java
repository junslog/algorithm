import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] sequence;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0, 0);
        System.out.println(count);
        br.close();
    }

    public static void backtracking(int index, int sum, int selected) {
        if (index == N) {
            if (selected == 0) {
                return;
            }
            if (sum == S) {
                count++;
            }
            return;
        }

        backtracking(index + 1, sum + sequence[index], selected + 1);
        backtracking(index + 1, sum, selected);
    }
}