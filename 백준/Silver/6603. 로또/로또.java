import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int numOfLotteryNums = 6;
    static int tcK;
    static List<Integer> tcNumbers;

    // rN = remaining Number ; rN의 개수만큼 dfs 돌 것
    public static void dfs(int rN, List<Integer> idxList, int lastIdx){
        List<Integer> idxListCopy = new LinkedList<>(idxList);

        if(rN == 0 || idxListCopy.size() == numOfLotteryNums) {
            for(int i = tcK - (numOfLotteryNums - idxListCopy.size()); i < tcK; i++)
                idxListCopy.add(i);
            for(int i = 0; i < numOfLotteryNums; i++)
                System.out.print(tcNumbers.get(idxListCopy.get(i)) + " ");
            System.out.println();
            return;
        }

        int rNMinusCounter = 0;
        int idx = lastIdx;
        do{
            idxListCopy.add(idx++);
            dfs(rN - rNMinusCounter, idxListCopy, idx);
            idxListCopy.remove(idxListCopy.size() - 1);
            rNMinusCounter++;
        } while((rN - rNMinusCounter) >= 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        List<Integer> kList = new LinkedList<>();
        List<List<Integer>> numbersList = new LinkedList<>();

        int k;
        List<Integer> numbers;

        // TestCase Setting
        while(true) {
            String input = br.readLine();
            if(input.equals("0"))
                break;

            st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            kList.add(k);

            numbers = new LinkedList<>();
            for (int i = 0; i < k; i++)
                numbers.add(Integer.parseInt(st.nextToken()));
            numbersList.add(numbers);
        }

        // TestCase별 출력
        for(int i = 0; i < kList.size(); i++){
            tcK = kList.get(i);
            tcNumbers = numbersList.get(i);
            dfs(tcK - numOfLotteryNums, new LinkedList<>(), 0);
            System.out.println();
        }
    }
}