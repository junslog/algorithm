import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static Board[] boards = new Board[8];
    static int safeStep = 7;

    public static void main(String[] args) throws IOException {
        makeBoards();
        Queue<WookJeStatus> q = new ArrayDeque<>();
        q.add(new WookJeStatus(0, 7, 0));
        int[] dx = {0, 1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

        boolean canGo = false;
        while (!q.isEmpty()) {
            WookJeStatus ws = q.poll();
            int currStep = ws.step;
            if (currStep >= safeStep) {
                canGo = true;
                break;
            }
            char[][] currBoard = boards[currStep].map;
            char[][] nextBoard = boards[currStep + 1].map;
            for (int i = 0; i < 9; i++) {
                int nx = ws.p.x + dx[i];
                int ny = ws.p.y + dy[i];
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                    continue;
                }
                if (currBoard[nx][ny] == '#' || nextBoard[nx][ny] == '#') {
                    continue;
                }
                q.add(new WookJeStatus(currStep + 1, nx, ny));
            }
        }
        if (canGo) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void makeBoards() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최초 미로 상태
        char[][] initBoard = new char[8][8];
        Queue<Position> walls = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                initBoard[i][j] = input.charAt(j);
                if (initBoard[i][j] == '#') {
                    walls.add(new Position(i, j));
                }
            }
        }
        boards[0] = new Board(initBoard);
        boolean found = false;
        // 총 8개의 미로 상태 계산
        for (int i = 1; i < 8; i++) {
            char[][] currBoard = new char[8][8];
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    currBoard[j][k] = '.';
                }
            }
            int currWallsCount = walls.size();
            if (currWallsCount == 0 && !found) {
                safeStep = i;
                found = true;
            }
            for (int j = 0; j < currWallsCount; j++) {
                Position p = walls.poll();
                int currX = p.x;
                int currY = p.y;
                if (currX == 7) {
                    continue;
                }
                currBoard[currX + 1][currY] = '#';
                walls.add(new Position(currX + 1, currY));
            }
            boards[i] = new Board(currBoard);
        }
    }

    static class Board {
        char[][] map;

        Board(char[][] map) {
            this.map = map;
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class WookJeStatus {
        int step;
        Position p;

        WookJeStatus(int step, int x, int y) {
            this.step = step;
            this.p = new Position(x, y);
        }
    }
}