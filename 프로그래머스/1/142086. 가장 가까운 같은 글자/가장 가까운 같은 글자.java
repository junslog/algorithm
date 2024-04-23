class Solution {
    public int[] solution(String s) {
        char[] input = s.toCharArray();
        int[] answer = new int[input.length];
        int answerLen = answer.length;
        for(int i = 0; i < answerLen; i++){
            answer[i] = -1;
        }
        
        for(int i = 0; i < input.length; i++){
            for(int j = i-1; j >= 0; j--){
                if(input[j] == input[i]){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        return answer;
    }
}