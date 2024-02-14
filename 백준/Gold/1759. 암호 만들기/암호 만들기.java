import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int L,C;
    static List<Character> mList = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
    static char[] input;
    static char[] items;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];
        items = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            input[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(input);
        backtracking(0,0);
        System.out.println(sb);
    }

    public static void backtracking(int selected, int index){
        if(selected == L){
            if(!isValid()){
                return;
            }
            for(char c : items){
                sb.append(c);
            }
            sb.append("\n");
            return;
        }

        if(index >= C){
            return;
        }

        items[selected] = input[index];
        backtracking(selected +1, index +1);
        items[selected] = '0';
        backtracking(selected, index+1);
    }

    public static boolean isValid(){
        int mCount = 0;
        int jCount = 0;
        for(int i = 0; i < L; i++){
            if(mList.contains(items[i])){
                mCount++;
            } else {
                jCount++;
            }
        }
        if(mCount >= 1 && jCount >= 2){
            return true;
        }
        return false;
    }
}