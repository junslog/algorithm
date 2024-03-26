import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node> tree;
    static int maxLevel = 0;
    static int[] levelMin;
    static int[] levelMax;
    static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Tree Init
        tree = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child1 = Integer.parseInt(st.nextToken());
            int child2 = Integer.parseInt(st.nextToken());
            Node p = null;
            for (Node n : tree) {
                if (n.value == parent) {
                    p = n;
                    p.existParent = true;
                    break;
                }
            }
            if (p == null) {
                p = new Node(parent);
                tree.add(p);
            }
            Node c1 = null;
            Node c2 = null;
            if (child1 != -1) {
                boolean found = false;
                for (Node n : tree) {
                    if (n.value == child1) {
                        found = true;
                        c1 = n;
                        break;
                    }
                }
                if (!found) {
                    c1 = new Node(child1);
                }
                c1.existParent = true;
                tree.add(c1);
            }

            if (child2 != -1) {
                boolean found = false;
                for (Node n : tree) {
                    if (n.value == child2) {
                        found = true;
                        c2 = n;
                        break;
                    }
                }
                if (!found) {
                    c2 = new Node(child2);
                }
                c2.existParent = true;
                tree.add(c2);
            }
            p.setLeft(c1);
            p.setRight(c2);
        }

        Node root = null;
        for (Node n : tree) {
            if (!n.existParent) {
                root = n;
                break;
            }
        }
        markLevel(root, 1);

        levelMin = new int[maxLevel + 1];
        levelMax = new int[maxLevel + 1];
        inOrder(root);

        int[] levelDistance = new int[maxLevel + 1];
        int levDistance = -1;
        int minLev = maxLevel;
        for (int i = maxLevel; i >= 1; i--) {
            levelDistance[i] = levelMax[i] - levelMin[i] + 1;
            if (levDistance <= levelDistance[i]) {
                levDistance = levelDistance[i];
                if (minLev > i) {
                    minLev = i;
                }
            }
        }
        System.out.println(minLev + " " + levelDistance[minLev]);
    }

    public static void markLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        root.level = level;
        if (maxLevel < level) {
            maxLevel = level;
        }
        markLevel(root.left, level + 1);
        markLevel(root.right, level + 1);
    }


    public static void inOrder(Node curr) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left);
        int currLevel = curr.level;
        order++;
        if (levelMin[currLevel] == 0) {
            levelMin[currLevel] = order;
        } else {
            if (levelMin[currLevel] > order) {
                levelMin[currLevel] = order;
            }
        }
        if (levelMax[currLevel] == 0) {
            levelMax[currLevel] = order;
        } else {
            if (levelMax[currLevel] < order) {
                levelMax[currLevel] = order;
            }
        }
        inOrder(curr.right);
    }


    public static class Node {
        int value;
        int level;
        boolean existParent;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.existParent = false;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }
}
