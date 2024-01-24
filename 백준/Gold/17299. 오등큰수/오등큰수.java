import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eSize = Integer.parseInt(br.readLine());

        // Initialize
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] elements = new int[eSize];
        for(int i = 0; i < eSize; i++){
            elements[i] = Integer.parseInt(st.nextToken());
        }

        // Element가 담길 Stack
        Stack<Integer> eStack = new Stack<>();
        // 오등큰수 후보가 담길 Stack
        Stack<Integer> oStack = new Stack<>();

        // 1. 순회하며 eStack에 Data 담음, F(i) 계산
        Map<Integer, Integer> Fi = new HashMap<>(eSize);
        for(int i = 0; i < eSize; i++){
            Fi.put(elements[i], Fi.getOrDefault(elements[i], 0) + 1);
            eStack.push(elements[i]);
        }

        // 2. NGF Map Initialize
        Map<Integer, Integer> NGF = new HashMap<>(eSize);
        for(int i = 0 ; i < eSize; i++){
            NGF.put(i, 0);
        }

        // 2. 계산
        int idxRunner = eSize - 1;
        while(!eStack.isEmpty()){
            // 초기값
            if(idxRunner == eSize - 1){
                NGF.put(idxRunner, -1);
                oStack.push(eStack.pop());
                idxRunner--;
                continue;
            }

            if(Fi.get(oStack.peek()) > Fi.get(eStack.peek())){
                NGF.put(idxRunner, oStack.peek());
                oStack.push(eStack.pop());
            } else {
                boolean found = true;
                while(Fi.get(oStack.peek()) <= Fi.get(eStack.peek())){
                    oStack.pop();
                    if(oStack.isEmpty()){
                        NGF.put(idxRunner, -1);
                        oStack.push(eStack.pop());
                        found = false;
                        break;
                    }
                }
                if(!oStack.isEmpty() && found) {
                    NGF.put(idxRunner, oStack.peek());
                    oStack.push(eStack.pop());
                }
            }
            idxRunner--;
        }

        // 출력
        StringBuilder sb = new StringBuilder(eSize*2);
        for(int i = 0; i < eSize; i++){
            if(i == eSize - 1){
                sb.append(NGF.get(i));
                break;
            }
            sb.append(NGF.get(i)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}