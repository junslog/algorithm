import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static int[] startTeam;
    static int[] linkTeam;
    static int minimumGap = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        startTeam = new int[N/2];
        linkTeam = new int[N/2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0,0, 0);
        System.out.println(minimumGap);
        br.close();
    }

    public static void combination(int startSelected, int linkSelected, int index) {
        // 해를 찾은 경우
        if (startSelected == N/2 || linkSelected == N/2) {
            if(startSelected != N/2){
                for(int i = startSelected; i < N/2; i++){
                    startTeam[i] = index++;
                }
            }
            if(linkSelected != N/2){
                for(int i = linkSelected; i < N/2; i++){
                    linkTeam[i] = index++;
                }
            }
            int teamGap = calculateTeamGap();
            if (teamGap < minimumGap) {
                minimumGap = teamGap;
            }
            return;
        }

        // 더 이상의 재귀가 의미 없는 경우 ( 불가능한 경우 )
        if (index >= N) {
            return;
        }

        // 재귀
        startTeam[startSelected] = index;
        combination(startSelected + 1, linkSelected,index + 1);

        linkTeam[linkSelected] = index;
        combination(startSelected, linkSelected + 1, index + 1);
    }

    public static int calculateTeamGap(){
        int startTeamSum = 0;
        for(int t1: startTeam){
            for(int t2 : startTeam){
                startTeamSum += S[t1][t2];
            }
        }
        int linkTeamSum = 0;
        for(int t1 : linkTeam){
            for(int t2 : linkTeam){
                linkTeamSum += S[t1][t2];
            }
        }
        return Math.abs(startTeamSum - linkTeamSum);
    }
}