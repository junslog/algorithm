import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static boolean[] checked = new boolean['Z' - 'A' + 1];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] inputs = new String[N];
    for (int i = 0; i < N; i++) {
      inputs[i] = br.readLine();
    }
    String[] outputs = new String[N];
    for (int i = 0; i < N; i++) {
      outputs[i] = makeToOutput(inputs[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (String output : outputs) {
      sb.append(output).append("\n");
    }
    System.out.println(sb);
  }

  private static String makeToOutput(String input) {

    String[] splited = input.split(" ");
    boolean found = false;

    int tempIdx = 0;
    for (int i = 0; i < splited.length; i++) {
      String curr = splited[i];
      char currFront = Character.toUpperCase(curr.charAt(0));
      if (!checked[currFront - 'A']) {
        tempIdx += i;
        checked[currFront - 'A'] = true;
        found = true;
        break;
      } else {
        tempIdx += (curr.length());
      }
    }

    boolean found2 = false;
    if (!found) {
      tempIdx = 0;
      for (int i = 0; i < splited.length; i++) {
        for (char c : splited[i].toCharArray()) {
          if (!checked[Character.toUpperCase(c) - 'A']) {
            tempIdx += i;
            found2 = true;
            checked[Character.toUpperCase(c) - 'A'] = true;
            break;
          }
          tempIdx++;
        }
        if (found2) {
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    if (found || found2) {
      for (int i = 0; i < input.length(); i++) {
        if (i != tempIdx) {
          sb.append(input.charAt(i));
        } else {
          sb.append('[').append(input.charAt(i)).append(']');
        }
      }
    } else {
      sb.append(input);
    }
    return sb.toString();
  }
}