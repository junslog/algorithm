import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 동생의 위치 모음
        int[] Ai = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        // 거리의 절대값 차이를 나타내는 배열 초기화
        int[] distAbs = new int[N];
        for(int i = 0; i < N; i++){
            distAbs[i] = distanceAbs(S, Ai[i]);
        }

        // 출력
        // 예외처리
        if(distAbs.length == 1){
            System.out.println(distAbs[0]);
            br.close();
            return;
        }

        Stack<Integer> gcdStack = new Stack<>();

        for(int i = 0; i < distAbs.length; i++){
            gcdStack.push(distAbs[i]);
        }

        while(true){
            int first = gcdStack.pop();
            if(gcdStack.isEmpty()){
                System.out.println(first);
                break;
            }
            int second = gcdStack.pop();
            int gcd = gcd(first, second);
            if(gcd == 1){
                System.out.println(gcd);
                break;
            }
            gcdStack.push(gcd);
        }
        br.close();
    }

    public static int distanceAbs(int subin, int younger){
        return Math.abs(subin-younger);
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}