import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] pick1 = {0, 0, 1};
    static int[] pick2 = {1, 2, 2};
    static boolean[][] visited = new boolean[1501][1501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] rocks = new int[3];
        rocks[0] = Integer.parseInt(st.nextToken());
        rocks[1] = Integer.parseInt(st.nextToken());
        rocks[2] = Integer.parseInt(st.nextToken());

        int sum = Arrays.stream(rocks).sum();
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        Queue<History> q = new ArrayDeque<>();
        q.add(new History(rocks));
        boolean isPossible = false;

        while (!q.isEmpty()) {
            History h = q.poll();
            int first = h.values[0];
            int second = h.values[1];
            int third = sum - (first + second);
            if ((first == second) && (second == third)) {
                isPossible = true;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int[] next = new int[3];
                int p1 = pick1[i];
                int p2 = pick2[i];

                int r1 = h.values[p1];
                int r2 = h.values[p2];
                int r3 = sum - (r1 + r2);

                if (r1 == r2) {
                    continue;
                }
                if (visited[r1][r2]) {
                    continue;
                }
                visited[r1][r2] = true;
                visited[r2][r1] = true;

                int max = Math.max(r1, r2);
                int min = Math.min(r1, r2);
                next[0] = max - min;
                next[1] = min + min;
                next[2] = r3;
                q.add(new History(next));
            }
        }
        if (isPossible) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class History {
        int[] values = new int[3];

        History(int[] rocks) {
            this.values[0] = rocks[0];
            this.values[1] = rocks[1];
            this.values[2] = rocks[2];
        }
    }
}