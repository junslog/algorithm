import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input 개수, input 내 최대값 찾기
        int numOfInputs = 0;
        int maxEvenNumber = 0;
        List<Integer> inputs = new ArrayList<>(10000);
        while(true){
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            inputs.add(input);
            numOfInputs++;
            if(maxEvenNumber < input){
                maxEvenNumber = input;
            }
        }

        // Input의 Max 값 까지 에라토스테네스 체 적용
        boolean[] check = new boolean[maxEvenNumber + 1];
        int[] pNumbers = new int[maxEvenNumber];
        int pN = 0;
        check[0] = check[1] = true;
        for(int i = 2; i <= maxEvenNumber; i++){
            if(!check[i]){
                pNumbers[pN++] = i;
                for(int j = i*2; j <= maxEvenNumber; j+=i){
                    check[j] = true;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder(10000);
        inputs.forEach(
                input -> {
                    for(int i = 2; i <= input; i++){
                        if(!check[i] && !check[input-i]){
                            sb.append(input).append(" = ").append(i)
                                    .append(" + ").append(input-i)
                                    .append("\n");
                            break;
                        }
                    }
                }
        );
        System.out.println(sb);
    }
}