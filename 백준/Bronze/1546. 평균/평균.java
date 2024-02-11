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
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> scoreList = new ArrayList<>(N);
        for(int i = 0; i < N; i++){
            scoreList.add(Integer.parseInt(st.nextToken()));
        }

        int M = scoreList.stream()
                .max((i1, i2) -> i1 - i2).get();
        double result = 0.0d;
        List<Double> convertedList = new ArrayList<>(N);
        for(int i = 0; i < scoreList.size(); i++){
            convertedList.add((scoreList.get(i) / (double) M) * 100);
        }

        for (Double d : convertedList) {
            result += d;
        }

        System.out.println(result/N);
    }
}