import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        loop:
        while (T-- > 0) {
            boolean direction = true; // true -> , false <-
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] vals = input.substring(1, input.length() - 1).split(",");
            for (int i = 0; i < N; i++) {
                q.add(Integer.parseInt(vals[i]));
            }
            for (char c : commands) {
                if (c == 'R') {
                    direction = !direction;
                }
                if (c == 'D') {
                    if (q.isEmpty()) {
                        sb.append("error\n");
                        continue loop;
                    }
                    if (direction) { // ->
                        q.pollFirst();
                    } else { // <-
                        q.pollLast();
                    }
                }
            }
            sb.append("[");
            while (!q.isEmpty()) {
                if (direction) {
                    sb.append(q.pollFirst());
                } else {
                    sb.append(q.pollLast());
                }
                if (!q.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}