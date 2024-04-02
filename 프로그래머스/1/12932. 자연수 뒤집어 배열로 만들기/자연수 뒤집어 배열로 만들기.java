import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(long n) {
        List<Integer> answerList = Arrays.stream(String.valueOf(n).split(""))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
        int answerSize = answerList.size();
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++){
            answer[i] = answerList.get(answerSize - i - 1);
        }
        return answer;
    }
}