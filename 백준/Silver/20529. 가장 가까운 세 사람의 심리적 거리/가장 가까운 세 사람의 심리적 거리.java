import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int[] indexs;
    static List<Mbti> currMbtis;
    static boolean[] visited;
    static int[] selectedIndexs = new int[3];
    static int minimumDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Map<Mbti, Integer> mbtiCounts = new HashMap<>();
            boolean existThreeOrMore = false;
            for (int i = 0; i < N; i++) {
                Mbti mbti = new Mbti(st.nextToken());
                int updateVal = mbtiCounts.getOrDefault(mbti, 0) + 1;
                if (updateVal >= 3) {
                    existThreeOrMore = true;
                    break;
                }
                mbtiCounts.put(mbti, updateVal);
            }
            if (existThreeOrMore) {
                // 같은 MBTI가 3명 이상이 있는 경우, 가장 가까운 심리적거리는 0
                sb.append(0).append("\n");
            } else {
                List<Mbti> existMbtis = new ArrayList<>();
                for (Mbti mbti : mbtiCounts.keySet()) {
                    existMbtis.add(mbti);
                    if (mbtiCounts.get(mbti) >= 2) {
                        // 2 개 이상이면 중복해서 add
                        existMbtis.add(mbti);
                    }
                }
                // 조합 찾기 백트래킹
                indexs = new int[existMbtis.size()];
                visited = new boolean[existMbtis.size()];
                currMbtis = existMbtis;
                minimumDistance = 9999999;
                combination(0, 0);
                sb.append(minimumDistance).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void combination(int depth, int startIdx) {
        if (depth == 3) {
            Mbti a = currMbtis.get(selectedIndexs[0]);
            Mbti b = currMbtis.get(selectedIndexs[1]);
            Mbti c = currMbtis.get(selectedIndexs[2]);
            int distance = a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
            if (minimumDistance > distance) {
                minimumDistance = distance;
            }
            return;
        }

        for (int i = startIdx; i < indexs.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selectedIndexs[depth] = i;
            combination(depth + 1, startIdx + 1);
            visited[i] = false;
        }
    }

    public static class Mbti {
        String value;

        Mbti(String mbti) {
            this.value = mbti;
        }

        public int getDistance(Mbti other) {
            char[] mbti = value.toCharArray();
            char[] otherMbti = other.value.toCharArray();
            int mismatch = 0;
            for (int i = 0; i < 4; i++) {
                if (mbti[i] != otherMbti[i]) {
                    mismatch++;
                }
            }
            return mismatch;
        }

        @Override
        public boolean equals(Object other) {
            Mbti otherMbti = (Mbti) other;
            return value.equals(otherMbti.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}