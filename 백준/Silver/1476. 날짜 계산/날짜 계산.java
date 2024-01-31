import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 0;
        int initE = 0;
        int initS = 0;
        int initM = 0;
        while(true){
            if(++initE % 16 == 0){
                initE = 1;
            }
            if(++initS % 29 == 0){
                initS = 1;
            }
            if(++initM % 20 == 0){
                initM = 1;
            }

            year++;
            if(E == initE && S == initS && M == initM){
                break;
            }
        }
        System.out.println(year);
        br.close();
    }
}