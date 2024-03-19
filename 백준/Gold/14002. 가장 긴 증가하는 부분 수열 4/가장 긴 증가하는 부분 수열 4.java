import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] curIdx = new int[N];
        int[] length = new int[N];

        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        curIdx[i] = j;
                    }
                }
            }
        }

        int max = -1;
        int maxStartIdx = -1;
        for (int i = 0; i < N; i++) {
            if (max < length[i]) {
                max = length[i];
                maxStartIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        List<Integer> lisReverse = new ArrayList<>();
        while (max-- > 0) {
            lisReverse.add(arr[maxStartIdx]);
            maxStartIdx = curIdx[maxStartIdx];
        }
        for (int i = lisReverse.size() - 1; i >= 0; i--) {
            sb.append(lisReverse.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
