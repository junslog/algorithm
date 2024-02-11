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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        // 1. A[i] < A[i-1] 인 최대 i를 찾는다.
        int pointIdx = 0;
        for(int i = 1; i < N; i++){
            if(input[i-1] > input[i]){
                pointIdx = i;
            }
        }
        if(pointIdx == 0) { // 모두 오름차순인 순열
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            // 2. j >= i 인 수 중, A[j] < A[i-1] 인 최대 j를 찾는다.
            int swapIdx = pointIdx;
            for(int i = pointIdx; i < N; i++){
                if(input[i] < input[pointIdx -1]){
                    swapIdx = i;
                }
            }
            // 3. A[j] 와 A[i-1] 을 Swap 한다.
            int temp = input[swapIdx];
            input[swapIdx] = input[pointIdx-1];
            input[pointIdx-1] = temp;
            // 4. A[i] 부터 A[n-1] 까지 수열을 뒤집는다.
            List<Integer> rememberList = new ArrayList<>();
            for(int i = pointIdx; i < N; i++){
                rememberList.add(input[i]);
            }
            int idx = 0;
            for(int i = N-1; i >= pointIdx; i--){
                input[i] = rememberList.get(idx);
                idx++;
            }
            for(int i = 0; i < N; i++){
                sb.append(input[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}