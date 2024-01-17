import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int maxValue = Integer.parseInt(br.readLine());

        int[] sequence = new int[maxValue];

        for(int i = 0; i < sequence.length; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();

        int counter = sequence.length;

        int sequenceIdx = 0;
        int pushCount = 0;
        int seqVal;
        while(counter-- > 0){
            seqVal = sequence[sequenceIdx];

            if(seqVal > pushCount){
                for(int i = pushCount; i < seqVal; i++)
                    s.push(i+1);
                s.pop();
                sb.append("+\n".repeat(seqVal - pushCount));
                sb.append("-\n");
                pushCount = seqVal;
            } else if(seqVal < pushCount){
                if(s.peek() == seqVal) {
                    s.pop();
                    if(sequenceIdx == sequence.length - 1)
                        sb.append("-");
                    else
                        sb.append("-\n");
                } else {
                    System.out.print("NO");
                    return;
                }
            }
            sequenceIdx++;
        }
        System.out.print(sb);
    }
}