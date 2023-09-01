import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Tower[] towers = new Tower[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < towers.length; i++)
            towers[i] = new Tower(Integer.parseInt(st.nextToken()), i + 1);

        int[] outputArr = new int[towers.length];

        Stack<Tower> s = new Stack<>();

        for(int i = 0; i < towers.length; i++){
            while(!s.isEmpty()){
                if(s.peek().getHeight() < towers[i].getHeight())
                    s.pop();
                else {
                    outputArr[i] = s.peek().getIndex();
                    s.push(towers[i]);
                    break;
                }
            }
            if(s.isEmpty()){
                outputArr[i] = 0;
                s.push(towers[i]);
            }
        }
        sb.append(Arrays.stream(outputArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        System.out.print(sb);
    }

    private static class Tower {
        private int height;
        private int index;
        public Tower(int height, int index){
            this.height = height;
            this.index = index;
        }
        public int getHeight(){
            return this.height;
        }
        public int getIndex(){
            return this.index;
        }
    }
}