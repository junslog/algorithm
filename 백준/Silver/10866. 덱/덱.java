import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> dequeList = new LinkedList<>();

        int commandNum = Integer.parseInt(br.readLine());
        String[] commands = new String[commandNum];

        for(int i = 0; i < commandNum; i ++){
            commands[i] = br.readLine();
        }

        int curCommandIdx = 0;
        String command;
        while(commandNum-- > 0){
            command = commands[curCommandIdx].split(" ")[0];
            Integer item;
            switch(command){
                case "push_front":
                    item = Integer.parseInt(commands[curCommandIdx].split(" ")[1]);
                    dequeList.add(0, item);
                    break;
                case "push_back":
                    item = Integer.parseInt(commands[curCommandIdx].split(" ")[1]);
                    dequeList.add(item);
                    break;
                case "pop_front":
                    if(dequeList.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    }
                    else {
                        item = dequeList.remove(0);
                        bw.write(String.valueOf(item));
                        bw.newLine();
                    }
                    break;
                case "pop_back":
                    if(dequeList.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    }
                    else {
                        item = dequeList.remove(dequeList.size()-1);
                        bw.write(String.valueOf(item));
                        bw.newLine();
                    }
                    break;
                case "front":
                    if(dequeList.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    }
                    else {
                        item = dequeList.get(0);
                        bw.write(String.valueOf(item));
                        bw.newLine();
                    }
                    break;
                case "back":
                    if(dequeList.isEmpty()) {
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    }
                    else {
                        item = dequeList.get(dequeList.size() - 1);
                        bw.write(String.valueOf(item));
                        bw.newLine();
                    }
                    break;
                case "empty":
                    if(dequeList.isEmpty()) {
                        bw.write(String.valueOf(1));
                        bw.newLine();
                    }
                    else {
                        bw.write(String.valueOf(0));
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(dequeList.size()));
                    bw.newLine();
                    break;
            }
            curCommandIdx++;
        }
        bw.flush();
    }
}