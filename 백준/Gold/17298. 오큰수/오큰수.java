import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int listSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Initialize
        Element[] elements = new Element[listSize];
        for(int i = 0; i < listSize; i++){
            elements[i] = new Element(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> okunsuStack = new Stack<>();
        Stack<Integer> okunsuRemainingStack = new Stack<>();
        int maxOkunsu = 0;

        for(int i = listSize -1; i >= 0; i--){
            // 처음 값 초기화
            if(i == listSize - 1){
                elements[i].setOkunsu(-1);
                continue;
            }

            if(elements[i].value < elements[i+1].value) {
                elements[i].setOkunsu(elements[i+1].value);
                maxOkunsu = Math.max(maxOkunsu, elements[i+1].value);
                okunsuStack.push(elements[i+1].value);
            } else if(elements[i].value < elements[i+1].okunsu){
                elements[i].setOkunsu(elements[i+1].okunsu);
                maxOkunsu = Math.max(maxOkunsu, elements[i+1].okunsu);
            } else if(elements[i].value >= elements[i+1].okunsu){
                if(elements[i].value < maxOkunsu) {
                    while (okunsuStack.peek() <= elements[i].value) {
                        okunsuRemainingStack.push(okunsuStack.pop());
                    }
                    elements[i].setOkunsu(okunsuStack.peek());
                    while (!okunsuRemainingStack.isEmpty()) {
                        okunsuStack.push(okunsuRemainingStack.pop());
                    }
                } else {
                        elements[i].setOkunsu(-1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < elements.length; i++){
            if(i == elements.length -1){
                sb.append(elements[i].okunsu);
                break;
            }
            sb.append(elements[i].okunsu).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    public static class Element{
        int value;
        int okunsu;
        public Element(int value){
            this.value = value;
        }
        public void setOkunsu(int okunsu) {
            this.okunsu = okunsu;
        }
    }
}