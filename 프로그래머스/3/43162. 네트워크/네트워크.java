class Solution {
    static int numOfComputers;
    static int[][] computer;
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        numOfComputers = n;
        computer = computers;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }   
        return count;
    }
    
    public static void dfs(int source){
        visited[source] = true;
        for(int i = 0; i < numOfComputers; i++){
            if(!visited[i] && computer[source][i] == 1){
                dfs(i);
            }
        }
    }
}