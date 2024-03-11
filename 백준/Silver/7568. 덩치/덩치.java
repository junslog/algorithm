import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Person> p = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < N; i++) {
            Person p1 = p.get(i);
            for (int j = 0; j < N; j++) {
                Person p2 = p.get(j);
                if (p1.isBiggerThan(p2)) {
                    p2.addRank();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(p.get(i).bigRank).append(" ");
        }
        System.out.println(sb);
    }

    public static class Person {
        int weight;
        int height;
        int bigRank = 1;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isBiggerThan(Person other) {
            return this.height > other.height && this.weight > other.weight;
        }

        public void addRank() {
            this.bigRank++;
        }
    }
}