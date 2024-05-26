import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int allPeople = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::new)
                .reduce((a, b) -> a * b)
                .getAsInt();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::new)
                .forEach(
                        i -> sb.append(i - allPeople).append(" ")
                );
        System.out.println(sb);
    }
}