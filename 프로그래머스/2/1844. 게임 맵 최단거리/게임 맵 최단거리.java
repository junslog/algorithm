import java.util.*;

class Solution {
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int minimumStep = 1;
    static int width, height;
    static int[][] inputMap;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        inputMap = maps;
        height = maps.length;
        width = maps[0].length;
        visited = new boolean[height][width];
        bfs();
        return minimumStep;
    }
    
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int k = 0; k < qSize; k++){
                Node elem = q.poll();
                for(int i = 0; i < 4; i++){
                    int nx = elem.x + dx[i];
                    int ny = elem.y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= height || ny >= width ){
                        continue;
                    }
                    if(visited[nx][ny] || inputMap[nx][ny] == 0){
                        continue;
                    }
                    if(nx == height - 1 && ny == width - 1){
                        minimumStep++;
                        return;
                    }
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
            minimumStep++;
        }
        minimumStep = -1;
    }
    
    public static class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }   
    }
}