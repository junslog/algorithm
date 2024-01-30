import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        System.out.println(op(N));
        br.close();
    }

    public static int op(int N){
        if(N == 1){
            return 0;
        }
        if(d[N] > 0){
            return d[N];
        }
        d[N] = op(N-1) + 1;
        if(N % 2 == 0){
            int temp = op(N/2) + 1;
            if(d[N] > temp){
                d[N] = temp;
            }
        }
        if(N % 3 == 0){
            int temp = op(N/3) + 1;
            if (d[N] > temp) {
                d[N] = temp;
            }
        }
        return d[N];
    }
}