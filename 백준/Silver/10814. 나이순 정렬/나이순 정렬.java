import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons.add(new Person(i, age, name));
        }
        List<Person> sortedPersons = persons.stream()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedPersons.size(); i++) {
            Person p = sortedPersons.get(i);
            sb.append(p.age)
                    .append(" ")
                    .append(p.name)
                    .append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static class Person implements Comparable<Person> {
        int entry;
        int age;
        String name;

        Person(int entry, int age, String name) {
            this.entry = entry;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age - o.age == 0) {
                return this.entry - o.entry;
            }
            return this.age - o.age;
        }
    }
}