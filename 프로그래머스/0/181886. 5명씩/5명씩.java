import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] names) {
        int runner = 0;
        List<String> answer = new ArrayList<>();
        for(String name : names){
            if(runner % 5 == 0){
                answer.add(name);
            }
            runner++;
        }
        return answer.stream().toArray(String[]::new);
    }
}