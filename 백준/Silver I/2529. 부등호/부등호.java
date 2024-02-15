import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int k;
    static boolean[] isUp;
    static boolean[] check;
    static int[] items;
    static List<String> itemsStored = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        isUp = new boolean[k];
        check = new boolean[10];
        for (int i = 0; i < k; i++) {
            if (st.nextToken().equals(">")) {
                isUp[i] = true;
            }
        }
        items = new int[k + 1];
        backtracking(0);
        Collections.sort(itemsStored);
        System.out.println(itemsStored.get(itemsStored.size() - 1));
        System.out.println(itemsStored.get(0));
        br.close();
    }

    public static void backtracking(int depth) {
        if (depth == k + 1) {
            if (checkCondition()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= k; i++) {
                    sb.append(items[i]);
                }
                itemsStored.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            items[depth] = i;
            backtracking(depth + 1);
            check[i] = false;
        }
    }

    public static boolean checkCondition() {
        boolean isValid = true;
        for (int j = 0; j < k; j++) {
            if (isUp[j]) {
                if (items[j] > items[j + 1]) {
                    continue;
                }
            } else {
                if (items[j] < items[j + 1]) {
                    continue;
                }
            }
            isValid = false;
            break;
        }
        return isValid;
    }
}