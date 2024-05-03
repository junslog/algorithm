class Solution {
    
    static int count = 0;
    static int b,s;
    static boolean[] visited;
    
    public int solution(int balls, int share) {
        visited = new boolean[balls];
        b = balls;
        s = share;
        backtracking(0,0);
        return count;
    }
    
    public static void backtracking(int depth, int startIdx){
        if(depth == s){
            count++;
            return;
        }
        
        for(int i = startIdx; i < b; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            backtracking(depth+1, i+1);
            visited[i] = false;
        }
    }
}