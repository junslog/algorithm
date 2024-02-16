import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String command, cmd;
        int oper;
        boolean[] set = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            command = br.readLine();
            if (command.equals("all") || command.equals("empty")) {
                if (command.equals("all")) {
                    for (int item = 1; item <= 20; item++) {
                        set[item] = true;
                    }
                }
                if (command.equals("empty")) {
                    for (int item = 1; item <= 20; item++) {
                        set[item] = false;
                    }
                }
            } else {
                cmd = command.split(" ")[0];
                oper = Integer.parseInt(command.split(" ")[1]);
                if (cmd.equals("add")) {
                    set[oper] = true;
                }
                if (cmd.equals("remove")) {
                    set[oper] = false;
                }
                if (cmd.equals("check")) {
                    if (set[oper]) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                }
                if (cmd.equals("toggle")) {
                    set[oper] = !set[oper];
                }
            }
        }
        System.out.println(sb);
    }
}