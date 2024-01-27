import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] check;
    static int[] pNumbers;
    static int pN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] inputNumbers = new int[T];

        int max = 0;
        for(int i = 0; i < T; i++){
            inputNumbers[i] = Integer.parseInt(br.readLine());
            if( max < inputNumbers[i] ){
                max = inputNumbers[i];
            }
        }

        // 에라토스테네스의 체
        check = new boolean[max + 1];
        pNumbers = new int[max];
        check[0] = true;
        check[1] = true;
        for(int i = 2; i <= max; i++){
            if(!check[i]){
                pNumbers[pN++] = i;
                for(int j = i*2; j <= max; j += i){
                    check[j] = true;
                }
            }
        }
        for(int i = 0; i < T; i++){
            sb.append(partitionNum(inputNumbers[i])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static int partitionNum(int input){
        boolean[] checkCopy = new boolean[input + 1];
        int len = checkCopy.length;
        for(int i = 0; i < len; i++){
            checkCopy[i] = check[i];
        }

        int partitionNum = 0;
        for(int i = 2; i <= input; i++){
            if(!checkCopy[i] && !checkCopy[input - i]){
                partitionNum++;
                checkCopy[i] = true;
                checkCopy[input-i] = true;
            }
        }
        return partitionNum;
    }
}