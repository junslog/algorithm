import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static int N, M;

    public static void dfs(boolean[] isChecked, int[] idxArr, int counter) {
        boolean[] isCheckedCopy = Arrays.copyOf(isChecked, N);
        int[] idxArrCopy = Arrays.copyOf(idxArr, M);

        if(counter == M) {
            for(int i = 0; i <= M - 1; i ++)
                System.out.print(arr[idxArrCopy[i]] + " ");
            System.out.println();
        }
        else {
            int curValue = 0;
            for (int i = 0; i < N; i++) {
                if (!isCheckedCopy[i] && curValue != arr[i]) {
                    curValue = arr[i];
                    idxArrCopy[counter] = i;
                    isCheckedCopy[i] = true;
                    dfs(isCheckedCopy, idxArrCopy,counter + 1);
                    isCheckedCopy[i] = false;
                }
            }
        }
    }

    // N 과 M (9)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        // arr Initiallization
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        // N개의 자연수 중에서 M개를 고른 수열
        int curValue = 0;
        boolean[] isChecked = new boolean[N];
        int[] idxArr = new int[M];
        for(int i = 0; i < N; i++){
            if(!isChecked[i] && curValue != arr[i]){
                curValue = arr[i];
                isChecked[i] = true;
                idxArr[0] = i;
                dfs(isChecked, idxArr,1);
                isChecked[i] = false;
            }
        }
    }
}