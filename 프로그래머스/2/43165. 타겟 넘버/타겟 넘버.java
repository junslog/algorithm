class Solution {
    
    static int[] inputNumbers;
    static int count = 0;
    static int maxIdx;
    static int targetNumber;
    
    public int solution(int[] numbers, int target) {
        inputNumbers = numbers;
        maxIdx = numbers.length;
        targetNumber = target;
        dfs(0, 0);
        return count;
    }
    
    public void dfs(int curValue, int curIdx){
        if(curIdx == maxIdx){
            if(curValue == targetNumber){
                count++;
            }
            return;
        }
        dfs(curValue + inputNumbers[curIdx], curIdx + 1);
        dfs(curValue - inputNumbers[curIdx], curIdx + 1);
    }
}