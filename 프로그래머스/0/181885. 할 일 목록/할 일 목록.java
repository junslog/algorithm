import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> toDos = new ArrayList<>();
        int runner = 0;
        for(boolean f : finished){
            if(!f){
                toDos.add(todo_list[runner]);
            }
            runner++;
        }
        return toDos.stream()
            .toArray(String[]::new);
    }
}