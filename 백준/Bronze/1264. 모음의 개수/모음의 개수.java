import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> bowels = new HashSet<>();
        char[] b = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char bb : b) {
            bowels.add(bb);
        }
        String input;
        StringBuilder sb = new StringBuilder();
        while (!((input = br.readLine()).equals("#"))) {
            int count = 0;
            for (char c : input.toCharArray()) {
                if (bowels.contains(c)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}