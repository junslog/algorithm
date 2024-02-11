import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int A, B, C;
        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0 0 0")){
            String[] inputSplited = input.split(" ");
            A = Integer.parseInt(inputSplited[0]);
            B = Integer.parseInt(inputSplited[1]);
            C = Integer.parseInt(inputSplited[2]);
            sb.append(isRightTriangle(A,B,C)? "right" : "wrong").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isRightTriangle(int A, int B, int C){
        int ASquare = A * A;
        int BSquare = B * B;
        int CSquare = C * C;
        int max = Math.max(Math.max(ASquare,BSquare),CSquare);
        if(max == ASquare){
            return ASquare == BSquare + CSquare ;
        }
        if(max == BSquare){
            return BSquare == ASquare + CSquare;
        }
        if(max == CSquare){
            return CSquare == ASquare + BSquare;
        }
        return false;
    }
}