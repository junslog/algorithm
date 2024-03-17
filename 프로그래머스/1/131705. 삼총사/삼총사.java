class Solution {
    static int[] items = new int[3];
    static int numOfThreeMan = 0;
    static int N;
    static boolean[] visited;
    static int[] numbers;
    
    public int solution(int[] number) {
        N = number.length;
        numbers = number;
        visited = new boolean[N];
        backtracking(0, 0);
        return numOfThreeMan;
    }
    
    public static void backtracking(int depth, int startIdx){
        if(depth == 3){
            int sum = items[0] + items[1] + items[2];
            if(sum == 0){
                numOfThreeMan++;
            }
            return;
        }
        
        for(int i = startIdx; i < N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            items[depth] = numbers[i];
            backtracking(depth+1, i+1);
            visited[i] = false;
        }
    }
}