import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        while ((s = br.readLine()) != null) {
            int target = Integer.parseInt(s) * 10000000;
            int N = Integer.parseInt(br.readLine());
            int[] l = new int[N];

            for (int i = 0; i < N; i++) {
                l[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(l);

            int left = 0, right = N - 1;
            boolean found = false;

            // Two-Pointer
            while (left < right) {
                int sum = l[left] + l[right];

                if (sum == target) {
                    System.out.println("yes " + l[left] + " " + l[right]);
                    found = true;
                    break;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            if (!found) {
                System.out.println("danger");
            }
            s = null;
        }
    }
}