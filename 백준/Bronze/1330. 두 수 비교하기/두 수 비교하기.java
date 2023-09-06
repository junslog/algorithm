import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        if(A > B)
            System.out.print(">");
        else if (A == B)
            System.out.print("==");
        else
            System.out.print("<");
    }
}