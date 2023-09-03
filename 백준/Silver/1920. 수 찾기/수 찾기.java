import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Initialization
        int N = Integer.parseInt(br.readLine()), M;
        int[] nArr = new int[N], mArr;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nArr.length; i++)
            nArr[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < mArr.length; i++)
            mArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nArr);

        for(int i : mArr){
            if(Arrays.binarySearch(nArr, i) <0)
                bw.write("0\n");
            else
                bw.write("1\n");
        }
        bw.close();
    }
}