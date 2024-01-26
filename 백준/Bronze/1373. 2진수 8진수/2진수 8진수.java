import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();

        int count = 0;
        char[] eightDigitValue = new char[3];
        StringBuilder sb = new StringBuilder();
        for (int i = inputArr.length - 1; i >= 0; i--) {
            count = (count + 1) % 4;
            eightDigitValue[count - 1] = inputArr[i];
            if (count == 3) {
                count = 0;
                sb.append(fromTwoToEight(eightDigitValue));
                eightDigitValue = new char[3];
            }
        }

        int remainingArrSize = inputArr.length % 3;
        if (remainingArrSize != 0) {
            if (remainingArrSize == 1) {
                sb.append(convertToNum(eightDigitValue[0]));
            }
            if (remainingArrSize == 2) {
                sb.append(convertToNum(eightDigitValue[0]) + convertToNum(eightDigitValue[1]) * 2);
            }
        }

        System.out.println(sb.reverse());
        br.close();
    }

    public static int fromTwoToEight(char[] eightDigitValue) {
        return convertToNum(eightDigitValue[0]) +
                convertToNum(eightDigitValue[1]) * 2 +
                convertToNum(eightDigitValue[2]) * 4;
    }

    public static int convertToNum(char input) {
        if (input == '0') {
            return 0;
        }
        if (input == '1') {
            return 1;
        }
        throw new RuntimeException("Non Binary Base Value");
    }
}