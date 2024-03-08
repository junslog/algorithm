import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[10];
        for (int i = 0; i < 10; i++) {
            input[i] = Integer.parseInt(br.readLine()) % 42;
        }
        Arrays.sort(input);
        int counter = 1;
        int remember = input[0];
        for (int i = 1; i < 10; i++) {
            if (remember == input[i]) {
                continue;
            }
            remember = input[i];
            counter++;
        }
        System.out.println(counter);
    }
}