import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int treeSize = (int) Math.pow(2, N + 1);
        tree = new char[treeSize];
        // tree Init
        StringTokenizer st = new StringTokenizer(br.readLine());
        char p = st.nextToken().charAt(0);
        char c1 = st.nextToken().charAt(0);
        char c2 = st.nextToken().charAt(0);
        List<Integer> idxs = new ArrayList<>();
        tree[0] = p;
        tree[0 * 2 + 1] = c1;
        tree[0 * 2 + 2] = c2;
        idxs.add(0);
        idxs.add(1);
        idxs.add(2);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            p = st.nextToken().charAt(0);
            c1 = st.nextToken().charAt(0);
            c2 = st.nextToken().charAt(0);
            int pIdx = -1;
            for (int idx : idxs) {
                if (p == tree[idx]) {
                    pIdx = idx;
                    break;
                }
            }
            tree[2 * pIdx + 1] = c1;
            tree[2 * pIdx + 2] = c2;
            idxs.add(2 * pIdx + 1);
            idxs.add(2 * pIdx + 2);
        }
        visitPre(0);
        sb.append("\n");
        visitMid(0);
        sb.append("\n");
        visitPost(0);
        System.out.println(sb);
    }

    public static void visitPre(int currIdx) {
        if (tree[currIdx] == '.') {
            return;
        }
        sb.append(tree[currIdx]);
        visitPre(currIdx * 2 + 1);
        visitPre(currIdx * 2 + 2);
    }

    public static void visitMid(int currIdx) {
        if (tree[currIdx] == '.') {
            return;
        }
        visitMid(currIdx * 2 + 1);
        sb.append(tree[currIdx]);
        visitMid(currIdx * 2 + 2);
    }

    public static void visitPost(int currIdx) {
        if (tree[currIdx] == '.') {
            return;
        }
        visitPost(currIdx * 2 + 1);
        visitPost(currIdx * 2 + 2);
        sb.append(tree[currIdx]);
    }
}
