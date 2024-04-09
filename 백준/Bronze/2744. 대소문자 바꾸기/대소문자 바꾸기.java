import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] output = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr - 'a' >= 0) {
                output[i] = Character.toUpperCase(curr);
            } else {
                output[i] = Character.toLowerCase(curr);
            }
        }
        System.out.println(new String(output));
    }
}