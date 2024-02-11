import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> count = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int key = Integer.parseInt(br.readLine());
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        for(int i = 1; i <= 10000; i++){
            if(count.getOrDefault(i, -1) == -1){
                continue;
            }
            int counter = count.get(i);
            for(int j = 0; j < counter; j++) {
                bw.append(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
    }
}