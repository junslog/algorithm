import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] items = new int[3];
    static int[] input;
    static int N, M;
    static int minimumGap = 999999999;
    static int sumOfMinimums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        System.out.println(sumOfMinimums);
    }

    public static void backtracking(int selected, int index) {
        if (selected == 3) {
            if (!isValid()) {
                return;
            }
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += items[i];
            }
            int gap = M - sum;
            if (gap < minimumGap) {
                minimumGap = gap;
                sumOfMinimums = sum;
            }
            return;
        }

        if (index >= N) {
            return;
        }

        items[selected] = input[index];
        backtracking(selected + 1, index + 1);
        backtracking(selected, index + 1);
    }

    public static boolean isValid() {
        return (items[0] + items[1] + items[2]) <= M;
    }
}