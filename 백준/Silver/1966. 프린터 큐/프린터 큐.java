import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] eachInputPriority = new int[N];
            int[] priority = new int[10]; // 1 ~ 9 까지 priority 개수
            Queue<Node> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            int order = 0;
            int markedPriority = -1;
            for (int i = 0; i < N; i++) {
                int currInputPriority = Integer.parseInt(st.nextToken());
                boolean isMarked = false;
                eachInputPriority[i] = currInputPriority;
                priority[currInputPriority]++;
                if (i == M) {
                    isMarked = true;
                    markedPriority = currInputPriority;
                }
                q.add(new Node(eachInputPriority[i], isMarked));
            }

            boolean found = false;
            for (int i = 9; i >= 1; i--) {
                if (priority[i] > 0) {
                    int currPriority = i;
                    boolean isMarkedPriority = (currPriority == markedPriority);
                    while (priority[i] > 0) {
                        Node elem = q.poll();
                        if (elem.priority != currPriority) {
                            q.add(elem);
                            continue;
                        }
                        priority[i]--;
                        order++;
                        if (isMarkedPriority && elem.isMarked) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
            sb.append(order).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node {
        int priority;
        boolean isMarked;

        Node(int priority, boolean isMarked) {
            this.priority = priority;
            this.isMarked = isMarked;
        }
    }
}