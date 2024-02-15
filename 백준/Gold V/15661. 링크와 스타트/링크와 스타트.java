import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> startTeam;
    static List<Integer> linkTeam;
    static int[][] S;
    static int minimumTeamGap = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        startTeam = new ArrayList<>();
        linkTeam = new ArrayList<>();
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0);
        System.out.println(minimumTeamGap);
        br.close();
    }

    public static void combination(int index) {
        if (index == N) {
            if (startTeam.size() == N || linkTeam.size() == N) {
                return;
            }
            int teamGap = calculateTeamGap();
            if (minimumTeamGap > teamGap) {
                minimumTeamGap = teamGap;
            }
            return;
        }
        startTeam.add(index);
        combination(index + 1);
        startTeam.remove(startTeam.size() - 1);
        linkTeam.add(index);
        combination(index + 1);
        linkTeam.remove(linkTeam.size() - 1);
    }

    public static int calculateTeamGap() {
        int startTeamSum = 0;
        for (int t1 : startTeam) {
            for (int t2 : startTeam) {
                startTeamSum += S[t1][t2];
            }
        }
        int linkTeamSum = 0;
        for (int t1 : linkTeam) {
            for (int t2 : linkTeam) {
                linkTeamSum += S[t1][t2];
            }
        }
        return Math.abs(startTeamSum - linkTeamSum);
    }
}