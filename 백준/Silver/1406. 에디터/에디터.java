


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 처음 써져있는 내용 입력
        String[] content = br.readLine().split("");

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 2. Stack Initialize
        List<Character> charList = Arrays.stream(content).map(v -> v.charAt(0)).collect(Collectors.toList());
        for(int i = 0; i < content.length; i++){
            left.push(charList.get(i));
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

       String output = new ArrayList<>(left).stream().map(Object::toString).collect(Collectors.joining(""));
//       bw.write(output);
//       bw.flush();
        System.out.println(output);
    }
}

