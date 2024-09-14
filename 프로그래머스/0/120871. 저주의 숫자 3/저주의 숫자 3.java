class Solution {
    public int solution(int n) {
        int answer = 0;
        int runner = 0;
        while(runner < n){
            answer++;
            while((answer % 3) == 0 || String.valueOf(answer).contains("3")){
                answer++;
            }
            runner++;
        }
        return answer;
    }
}