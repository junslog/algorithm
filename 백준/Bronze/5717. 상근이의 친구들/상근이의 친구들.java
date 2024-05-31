import java.io.*;
import java.util.Arrays;

class Main{
    
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String input;
         StringBuilder sb = new StringBuilder();
         while(!(input = br.readLine()).equals("0 0")){
             sb.append(Arrays.stream(input.split(" "))
                       .mapToInt(Integer::parseInt)
                       .sum())
                 .append("\n");
         }
         System.out.println(sb);
     }
}