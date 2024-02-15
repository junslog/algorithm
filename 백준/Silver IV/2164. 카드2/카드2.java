import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int finalCard = calculateFinalCard();
        System.out.println(finalCard);
    }

    public static int calculateFinalCard() {
        if (q.size() == 1) {
            return q.poll();
        }
        while (true) {
            q.poll();
            if (q.size() == 1) {
                break;
            }
            q.add(q.poll());
        }
        return q.poll();
    }
}