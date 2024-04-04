import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        int[] words = new int[26];

        int inputLen = input.length;
        String curr;
        for (int i = 0; i < inputLen; i++) {
            curr = input[i];
            int currLen = curr.length();
            String[] currSplit = curr.split("");
            for (int j = 0; j < currLen; j++) {
                words[currSplit[j].charAt(0) - 'A'] += (int) Math.pow(10, currLen - j - 1);
            }
        }

        Arrays.sort(words);
        int sum = 0;
        int runner = 9;
        for (int i = words.length - 1; i >= 0; i--) {
            sum += (words[i] * runner);
            runner--;
        }
        System.out.println(sum);
    }
}