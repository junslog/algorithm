import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      if (input.length() >= M) {
        map.put(input, map.getOrDefault(input, 0) + 1);
      }
    }

    Queue<Word> q = new PriorityQueue<>();
    for (String content : map.keySet()) {
      q.add(new Word(content, map.get(content)));
    }
    int qSize = q.size();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < qSize; i++) {
      sb.append(q.poll().content).append("\n");
    }
    System.out.println(sb);
  }

  static class Word implements Comparable<Word> {

    String content;
    int count;

    Word(String content, int count) {
      this.content = content;
      this.count = count;
    }

    @Override
    public int compareTo(Word other) {
      if (this.count != other.count) {
        return other.count - this.count;
      }
      if (this.content.length() != other.content.length()) {
        return other.content.length() - this.content.length();
      }
      return this.content.compareTo(other.content);
    }
  }

}
