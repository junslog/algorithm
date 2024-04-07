import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] w;
    static int[] shuffle;
    static boolean[] visited;
    static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        // 1 ... n-2 까지의 순열 구하기
        shuffle = new int[N - 2];
        visited = new boolean[N]; // 0, N-1 번째 idx 사용 x
        backtracking(0);
        System.out.println(maxEnergy);
    }

    public static void backtracking(int depth) {
        if (depth == N - 2) {
            gainEnergy();
            return;
        }

        for (int i = 1; i <= N - 2; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            shuffle[depth] = i;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }

    public static void gainEnergy() {
        int energy = 0;
        boolean[] visit = new boolean[N];
        for (int i = 0; i <= N - 3; i++) {
            int currIdx = shuffle[i];
            visit[currIdx] = true;
            int rightIdx = 0;
            for (int r = currIdx - 1; r >= 0; r--) {
                if (visit[r]) {
                    continue;
                }
                rightIdx = r;
                break;
            }
            int leftIdx = N - 1;
            for (int l = currIdx + 1; l <= N - 1; l++) {
                if (visit[l]) {
                    continue;
                }
                leftIdx = l;
                break;
            }
            energy += w[rightIdx] * w[leftIdx];
        }
        maxEnergy = Math.max(energy, maxEnergy);
    }
}