import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> d = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            d.addLast(i);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] firstSet = new int[N];
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(st.nextToken());
            int idx = -1;
            if (command == 1) {
                idx = d.pollFirst();
            } else if (command == 2) {
                int save = d.pollFirst();
                idx = d.pollFirst();
                d.addFirst(save);
            } else if (command == 3) {
                idx = d.pollLast();
            }
            firstSet[idx] = N - i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(firstSet[i]).append(" ");
        }
        System.out.println(sb);
    }
}
