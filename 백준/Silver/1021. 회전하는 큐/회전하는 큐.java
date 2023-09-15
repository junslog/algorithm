import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> jiminQueue = new LinkedList<>();

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int qLength = inputs[0], numOfPops = inputs[1];

        int[] numsToBePopped = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < qLength; i++)
            jiminQueue.add(i+1);

        int numToBePopped = 0;
        int arrIdx = 0;
        int lastIdx = 0;
        int sum = 0;
        while(numOfPops-- > 0){
            numToBePopped = numsToBePopped[arrIdx];
            int itemIdx = jiminQueue.indexOf(numToBePopped);
            sum += Math.min(Math.abs(itemIdx-lastIdx), Math.abs(jiminQueue.size() - Math.abs(itemIdx-lastIdx)));
            lastIdx = itemIdx;
            jiminQueue.remove(itemIdx);
            arrIdx++;
        }
        bw.write(""+sum);
        bw.flush();
    }
}