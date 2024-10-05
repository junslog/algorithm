class Solution {
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public int[][] solution(int n) {
        
        int[][] answer = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int x = 0, y = 0, runner = 1;
        int dir = 0;
        answer[0][0] = runner;
        visited[0][0] = true;
        
        while(runner < n * n){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= n || ny >= n || nx < 0 || ny < 0){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            if(visited[nx][ny]){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
            runner++;
            visited[nx][ny] = true;
            answer[nx][ny] = runner;
        }
        return answer;
    }
}