import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> suffixArray = new ArrayList<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            suffixArray.add(input.substring(i));
        }
        Collections.sort(suffixArray);
        for (String s : suffixArray) {
            System.out.println(s);
        }
    }
}