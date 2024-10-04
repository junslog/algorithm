import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] visitee = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      visitee[i] = Integer.parseInt(st.nextToken());
    }
    int left = 0;
    int right = K - 1;
    int sum = 0;
    for (int i = 0; i < K; i++) {
      sum += visitee[i];
    }
    int maxVisitee = sum;

    Map<Integer, Integer> visiteeCountMap = new HashMap<>();
    visiteeCountMap.put(maxVisitee, 1);
    while (right < N - 1) {
      sum -= visitee[left];
      left++;
      right++;
      sum += visitee[right];
      maxVisitee = Math.max(maxVisitee, sum);
      visiteeCountMap.put(sum, visiteeCountMap.getOrDefault(sum, 0) + 1);
    }
    System.out.println(maxVisitee == 0 ? "SAD" : maxVisitee);
    if (maxVisitee != 0) {
      System.out.println(visiteeCountMap.get(maxVisitee));
    }
  }
}