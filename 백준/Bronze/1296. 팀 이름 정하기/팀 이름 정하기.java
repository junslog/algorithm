import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String y = br.readLine();
        int L = 0, O = 0, V = 0, E = 0;
        for (char c : y.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'O') {
                O++;
            } else if (c == 'V') {
                V++;
            } else if (c == 'E') {
                E++;
            }
        }

        int T = Integer.parseInt(br.readLine());
        String[] candidates = new String[T];
        for (int i = 0; i < T; i++) {
            candidates[i] = br.readLine();
        }

        int winIdx = -1;
        int maxScore = -1;

        int runner = 0;
        int[] scores = new int[T];
        for (String candidate : candidates) {
            int score = 0;
            int rL = L, rO = O, rV = V, rE = E;
            for (char c : candidate.toCharArray()) {
                if (c == 'L') {
                    rL++;
                } else if (c == 'O') {
                    rO++;
                } else if (c == 'V') {
                    rV++;
                } else if (c == 'E') {
                    rE++;
                }
            }
            score = calcScore(rL, rO, rV, rE);
            scores[runner] = score;
            if (score > maxScore) {
                maxScore = score;
                winIdx = runner;
            }
            runner++;
        }

        List<String> cs = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                cs.add(candidates[i]);
            }
        }
        Collections.sort(cs);

        System.out.println(cs.get(0));
    }

    public static int calcScore(int rL, int rO, int rV, int rE) {
        int LpO = rL + rO;
        int LpV = rL + rV;
        int LpE = rL + rE;
        int OpV = rO + rV;
        int OpE = rO + rE;
        int VpE = rV + rE;
        return (LpO * LpV * LpE * OpV * OpE * VpE) % 100;
    }
}