import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime = new boolean[10000];

    static {
        // 에라토스테네스의 체
        for (int i = 2; i <= 9999; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= 9999; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 9999; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Step> q = new ArrayDeque<>();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[10000];
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == end) {
                sb.append(0).append("\n");
                continue;
            }
            visited[start] = true;
            q.add(new Step(start, 0));
            boolean isImpossible = true;
            while (!q.isEmpty()) {
                Step curr = q.poll();
                int currValue = curr.value;
                int currStep = curr.step;
                if (currValue == end) {
                    q.clear();
                    isImpossible = false;
                    sb.append(currStep).append("\n");
                    break;
                }
                for (int i = 1000; i <= 9999; i++) {
                    if (isPrime[i] && !visited[i]) {
                        if (isOneDigitDifferent(currValue, i)) {
                            visited[i] = true;
                            q.add(new Step(i, currStep + 1));
                        }
                    }
                }
            }
            if (isImpossible) {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isOneDigitDifferent(int source, int given) {
        String sourceStr = String.valueOf(source);
        String givenStr = String.valueOf(given);
        int matchCount = 0;
        for (int i = 0; i < 4; i++) {
            if (sourceStr.charAt(i) == givenStr.charAt(i)) {
                matchCount++;
            }
        }
        return matchCount == 3;
    }

    public static class Step {
        int value;
        int step;

        Step(int value, int step) {
            this.value = value;
            this.step = step;
        }
    }
}