import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Queue<CurrPosition> q = new ArrayDeque<>();
        q.add(new CurrPosition("", s));
        boolean[] visited = new boolean[100_000_0001];

        if (s == t) {
            System.out.println(0);
            return;
        }

        Queue<String> vals = new PriorityQueue<>();
        while (!q.isEmpty()) {
            CurrPosition cp = q.poll();
            long currValue = cp.value;
            String currLine = cp.line;

            if (currValue == t) {
                System.out.println(currLine);
                return;
            }

            long next = 0L;
            String[] ops = {"*", "+", "-", "/"};
            // 아스키 코드 순서대로 연산
            for (int l = 0; l < 4; l++) {
                switch (l) {
                    case 0:
                        if (currValue * currValue > 100_000_0000) {
                            break;
                        }
                        next = currValue * currValue;
                        break;
                    case 1:
                        if (currValue * 2 > 100_000_0000) {
                            break;
                        }
                        next = currValue * 2;
                        break;
                    case 2:
                        next = 0;
                        break;
                    case 3:
                        if (currValue != 0) {
                            next = 1;
                        }
                        break;
                }
                // 중복된 숫자가 아니면
                if (!visited[(int) next]) {
                    visited[(int) next] = true;
                    q.add(new CurrPosition(currLine + ops[l], next));
                }
            }
        }
        System.out.println(-1);
    }

    public static class CurrPosition {
        String line;
        long value;

        CurrPosition(String line, long value) {
            this.line = line;
            this.value = value;
        }
    }
}