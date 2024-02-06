import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calculateCumulativeDigit(N));
        br.close();
    }

    public static int calculateCumulativeDigit(int N){
        int digit = countNumberDigit(N);
        int increasingDigitCount = 0;
        double result = 0;
        double upperLimit = Math.pow(10, digit - 1);
        for(double i = 1; i < upperLimit; i = i *10){
            result += (increasingDigitCount + 1) * 9 * Math.pow(10, increasingDigitCount++);
        }
        result += ( (N - upperLimit + 1) * (increasingDigitCount + 1));
        return (int) result;
    }

    private static int countNumberDigit(int N){
        int digit = 0;
        while(N > 0){
            N = N / 10;
            digit++;
        }
        return digit;
    }
}