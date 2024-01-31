import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] board;
    static int maxCandyCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Board Initialize
        int N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        for(int i = 0; i < N; i++){
            String[] strs = br.readLine().split("");
            for(int j = 0; j < N; j++){
                board[i][j] = strs[j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                swap(i,j);
            }
        }
        System.out.println(maxCandyCount);
        br.close();
    }

    public static void swap(int x, int y){
        if(x + 1 < board.length){
            // swap
            String temp = board[x][y];
            board[x][y] = board[x+1][y];
            board[x+1][y] = temp;

            // update
            int max = search();
            if(maxCandyCount < max){
                maxCandyCount = max;
            }

            // re-swap
            board[x+1][y] = board[x][y];
            board[x][y] = temp;
        }

        if(y + 1 < board.length){
            // swap
            String temp = board[x][y];
            board[x][y] = board[x][y+1];
            board[x][y+1] = temp;

            // update
            int max = search();
            if(maxCandyCount < max){
                maxCandyCount = max;
            }

            // re-swap
            board[x][y+1] = board[x][y];
            board[x][y] = temp;
        }
    }

    public static int search(){
        int candyCount;
        int maxCandySaved = 0;
        String curCandy;
        // 가로 세트
        for(int i = 0; i < board.length; i++){
            curCandy = board[i][0];
            candyCount = 0;
            for(int j = 0; j < board.length; j++){
                if(curCandy.equals(board[i][j])){
                    candyCount++;
                } else {
                    curCandy = board[i][j];
                    if(candyCount > maxCandySaved){
                        maxCandySaved = candyCount;
                    }
                    candyCount = 1;
                }
            }
            if(candyCount > maxCandySaved){
                maxCandySaved = candyCount;
            }
        }

        // 세로 세트
        for(int i = 0; i < board.length; i++){
            curCandy = board[0][i];
            candyCount = 0;
            for(int j = 0; j < board.length; j++){
                if(curCandy.equals(board[j][i])){
                    candyCount++;
                } else {
                    curCandy = board[j][i];
                    if(candyCount > maxCandySaved){
                        maxCandySaved = candyCount;
                    }
                    candyCount = 1;
                }
            }
            if(candyCount > maxCandySaved){
                maxCandySaved = candyCount;
            }
        }
        return maxCandySaved;
    }
}