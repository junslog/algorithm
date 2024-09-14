class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] hasPuddle = new boolean[m+1][n+1];
        long[][] steps = new long[m+1][n+1];
        steps[1][1] = 1;
        
        for(int[] pos : puddles){
            steps[pos[0]][pos[1]] = 0;
            hasPuddle[pos[0]][pos[1]] = true;
        }
        
        for(int i = 2; i <= m; i++){
            if(hasPuddle[i][1]){
                break;
            }
            steps[i][1] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            if(hasPuddle[1][i]){
                break;
            }
            steps[1][i] = 1;
        }
        
        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                if(hasPuddle[i][j]){
                    continue;
                }
                steps[i][j] = (steps[i][j-1] + steps[i-1][j]) % 1000000007;
            }
        }
        return (int) steps[m][n];
    }
}