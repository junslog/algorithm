import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1. 처음 써져있는 내용 입력
            char[] content = br.readLine().toCharArray();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : content) {
                left.push(c);
            }

            // 3. 커맨드 개수 입력
            int numOfCommands = Integer.parseInt(br.readLine());

            // 4. 명령어 값들 초기화
            String[] commands = new String[numOfCommands];
            for(int i = 0; i < commands.length; i++){
                commands[i] = br.readLine();
            }

            int commandNum = 0;

            char command;
            while(numOfCommands-- > 0){
                command = commands[commandNum].charAt(0);

                switch(command) {
                    case 'L':
                        if (!left.isEmpty())
                            right.push(left.pop());
                        break;
                    case 'D':
                        if (!right.isEmpty())
                            left.push(right.pop());
                        break;
                    case 'B':
                        if(!left.isEmpty())
                            left.pop();
                        break;
                    case 'P':
                        char insertedChar = commands[commandNum].split(" ")[1].charAt(0);
                        left.push(insertedChar);
                        break;
                }
                commandNum++;
            }

            while(!right.isEmpty())
                left.push(right.pop());
            while(!left.isEmpty()){
                right.push(left.pop());
            }
            while(!right.isEmpty()){
                bw.append(right.pop());
            }
            bw.flush();
            br.close();
            bw.close();
        }
    }