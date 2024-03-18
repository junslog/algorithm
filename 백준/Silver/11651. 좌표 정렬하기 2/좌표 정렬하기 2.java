import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Position> pList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pList.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(pList);
        for (Position p : pList) {
            System.out.println(p);
        }
    }

    public static class Position implements Comparable<Position> {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Position other) {
            if (this.y != other.y) {
                return this.y - other.y;
            } else {
                return this.x - other.x;
            }
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}