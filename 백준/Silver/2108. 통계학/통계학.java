import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            values.put(v, values.getOrDefault(v, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        // 산술평균
        int sp = 0;
        for (int i = -4000; i <= 4000; i++) {
            sp += i * values.getOrDefault(i, 0);
        }
        sp = Math.round(sp / (float) N);
        sb.append(sp).append("\n");

        // 중앙값 -> TLE 시, Collections.sort()로 바꿀 것
        int target = N / 2 + 1;
        int runner = 0;
        int startV = -4000;
        int middleV = 0;
        while (true) {
            runner += values.getOrDefault(startV, 0);
            if (runner >= target) {
                middleV = startV;
                break;
            }
            startV++;
        }
        sb.append(middleV).append("\n");

        // 최빈값
        int maxOccur = 0;
        for (int i = -4000; i <= 4000; i++) {
            int occur = values.getOrDefault(i, 0);
            if (maxOccur < occur) {
                maxOccur = occur;
            }
        }
        List<Integer> maxOccurCandidates = new ArrayList<>();
        for (int i = -4000; i <= 4000; i++) {
            int occur = values.getOrDefault(i, 0);
            if (occur == maxOccur) {
                maxOccurCandidates.add(i);
            }
        }
        if (maxOccurCandidates.size() > 1) {
            sb.append(maxOccurCandidates.get(1)).append("\n");
        } else {
            sb.append(maxOccurCandidates.get(0)).append("\n");
        }

        // 범위
        boolean minFound = false;
        int min = 0;
        int max = 0;
        for (int i = -4000; i <= 4000; i++) {
            int v = values.getOrDefault(i, 0);
            if (!minFound && v > 0) {
                min = i;
                minFound = true;
            }
            if (v > 0) {
                max = i;
            }
        }
        int range = max - min;
        sb.append(range);
        System.out.println(sb);
    }
}