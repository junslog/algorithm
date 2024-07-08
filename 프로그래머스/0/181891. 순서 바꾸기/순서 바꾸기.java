import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = num_list.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int currIdx = (i + n) % size;
            list.add(num_list[currIdx]);
        }
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}