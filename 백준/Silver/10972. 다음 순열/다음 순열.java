import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 수열 A[n] 에 대하여, A[i] > A[i-1] 인 최대 i를 찾는다.
        int pointIdx = 0;
        for(int i = 0; i < N-1; i++){
            if(input[i+1] > input[i]){
                pointIdx = i + 1;
            }
        }
        if(pointIdx == 0){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            int valueToBeSwapped = input[pointIdx - 1];
            int swapIdx = -1;
            // 2. j >= i 인 j 중 , A[j] > A[i-1] 인 최대 j를 찾는다.
            for (int j = pointIdx; j < N; j++) {
                if(input[j] > valueToBeSwapped){
                    swapIdx = j;
                }
            }
            // 3. A[i-1]과 A[j] 를 Swap
            int temp = input[pointIdx -1];
            input[pointIdx -1] = input[swapIdx];
            input[swapIdx] = temp;
            // 4. A[i] 부터 수열을 뒤집는다.
            List<Integer> items = new ArrayList<>();
            for(int i = pointIdx; i < N; i++){
                items.add(input[i]);
            }
            int idx = 0;
            for(int i = N-1; i >= pointIdx; i--){
                input[i] = items.get(idx);
                idx++;
            }
            for(int i = 0; i < N; i++){
                sb.append(input[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}