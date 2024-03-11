import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[200000001];
        Map<Integer, Integer> idxToCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx <= 0) {
                idx = 10000000 - Math.abs(idx);
            } else {
                idx = 10000000 + idx;
            }
            if (check[idx]) {
                idxToCount.put(idx, idxToCount.get(idx) + 1);
            } else {
                check[idx] = true;
                idxToCount.put(idx, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> keys = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx <= 0) {
                idx = 10000000 - Math.abs(idx);
            } else {
                idx = 10000000 + idx;
            }
            if (check[idx]) {
                sb.append(idxToCount.get(idx)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}