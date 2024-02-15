import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>(N);
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int[] items = new int[N];
        int idx = 0;
        int counter = 0;
        while (!q.isEmpty()) {
            counter++;
            if (counter % K == 0) {
                items[idx++] = q.poll();
            } else {
                q.add(q.poll());
            }
        }
        sb.append("<");
        for (int i = 0; i < items.length; i++) {
            if (i == items.length - 1) {
                sb.append(items[i]);
                continue;
            }
            sb.append(items[i]).append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}