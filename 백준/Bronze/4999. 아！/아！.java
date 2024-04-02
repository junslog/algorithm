import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String j = br.readLine();
        String d = br.readLine();
        if (j.contains(d)) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}