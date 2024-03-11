import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Queue<Element> q = new LinkedList<>();
        Element initElement = new Element(1, 0, 0);
        q.add(initElement);
        List<Element> visited = new ArrayList<>();

        Element target;
        while (true) {
            Element currElem = q.poll();
            if (visited.contains(currElem)) {
                continue;
            }
            visited.add(currElem);
            if (currElem.value == S) {
                target = currElem;
                break;
            }
            if (currElem.value > 0) {
                q.add(new Element(currElem.value - 1, currElem.clipBoard, currElem.depth + 1));
                if (currElem.value < S) {
                    q.add(new Element(currElem.value, currElem.value, currElem.depth + 1));
                    q.add(new Element(currElem.value + currElem.clipBoard, currElem.clipBoard, currElem.depth + 1));
                }
            }
        }
        System.out.println(target.depth);
        br.close();
    }

    public static class Element extends Object {
        int value;
        int clipBoard;
        int depth;

        Element(int value, int clipBoard, int depth) {
            this.value = value;
            this.clipBoard = clipBoard;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object other) {
            Element otherElem = (Element) other;
            return this.value == otherElem.value && this.clipBoard == otherElem.clipBoard;
        }
    }
}