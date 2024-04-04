import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String[] input;
    static boolean[] selected;
    static int maxWords = Integer.MIN_VALUE;
    static char[] shouldLearn = {'a', 'n', 't', 'i', 'c'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        if (K < 5) {
            System.out.println(0);
        } else {
            selected = new boolean[26];
            for (char c : shouldLearn) {
                selected[c - 'a'] = true;
            }
            backtracking(0, 0);
            System.out.println(maxWords);
        }
    }

    public static void backtracking(int depth, int selectNum) {
        if (selectNum == K - 5) {
            int answer = 0;
            for (String s : input) {
                char[] inputChar = s.toCharArray();
                boolean isValid = true;
                for (char c : inputChar) {
                    if (!selected[c - 'a']) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    answer++;
                }
            }
            maxWords = Math.max(answer, maxWords);
            return;
        }

        if (depth > selected.length - 1) {
            return;
        }

        backtracking(depth + 1, selectNum);
        if (!selected[depth]) {
            selected[depth] = true;
            backtracking(depth + 1, selectNum + 1);
            selected[depth] = false;
        }
    }
}