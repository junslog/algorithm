import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String command, cmd;
        int oper;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            command = br.readLine();
            if (command.equals("all") || command.equals("empty")) {
                if (command.equals("all")) {
                    for (int item = 1; item <= 20; item++) {
                        set.add(item);
                    }
                }
                if (command.equals("empty")) {
                    for (int item = 1; item <= 20; item++) {
                        set.remove(item);
                    }
                }
            } else {
                cmd = command.split(" ")[0];
                oper = Integer.parseInt(command.split(" ")[1]);
                if (cmd.equals("add")) {
                    set.add(oper);
                }
                if (cmd.equals("remove")) {
                    set.remove(oper);
                }
                if (cmd.equals("check")) {
                    if (set.contains(oper)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                }
                if (cmd.equals("toggle")) {
                    if (set.contains(oper)) {
                        set.remove(oper);
                    } else {
                        set.add(oper);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}