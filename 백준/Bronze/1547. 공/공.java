import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aIdx = findIdx(a);
            int bIdx = findIdx(b);

            int temp = arr[aIdx];
            arr[aIdx] = arr[bIdx];
            arr[bIdx] = temp;
        }
        System.out.println(arr[0]);
    }

    public static int findIdx(int value) {
        for (int i = 0; i < 3; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}