import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String g = br.readLine();
        if (g.equals("F")) {
            System.out.println("0.0");
            return;
        }
        String[] gpa = g.split("");
        char grade = gpa[0].charAt(0);
        int point = Math.abs(grade - 'D' - 1);
        char op = gpa[1].charAt(0);
        StringBuilder sb = new StringBuilder();
        if (op == '-') {
            point--;
            sb.append(point).append(".7");
        } else {
            sb.append(point).append(".");
            if (op == '0') {
                sb.append("0");
            } else if (op == '+') {
                sb.append("3");
            }
        }
        System.out.println(sb);
    }
}