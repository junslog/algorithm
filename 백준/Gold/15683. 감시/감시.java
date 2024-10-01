import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static List<Camera> cameras = new ArrayList<>();
  static List<TypeDirection> typeDirections = new ArrayList<>();
  static Cell[][] cells;
  static int minUndarkenSpace = Integer.MAX_VALUE;

  static {
    // type1
    typeDirections.add(new TypeDirection(
        new Direction(true, false, false, false),
        new Direction(false, true, false, false),
        new Direction(false, false, true, false),
        new Direction(false, false, false, true)
    ));

    // type2
    typeDirections.add(new TypeDirection(
        new Direction(true, false, true, false),
        new Direction(false, true, false, true)
    ));

    // type3
    typeDirections.add(new TypeDirection(
        new Direction(true, false, false, true),
        new Direction(true, true, false, false),
        new Direction(false, true, true, false),
        new Direction(false, false, true, true)
    ));

    // type4
    typeDirections.add(new TypeDirection(
        new Direction(true, false, true, true),
        new Direction(true, true, false, true),
        new Direction(true, true, true, false),
        new Direction(false, true, true, true)
    ));

    // type5
    typeDirections.add(new TypeDirection(
        new Direction(true, true, true, true)
    ));
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    cells = new Cell[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int type = Integer.parseInt(st.nextToken());
        if (type == 0) {
          cells[i][j] = new Cell();
        } else if (type >= 1 && type <= 5) {
          Camera camera = new Camera(type, i, j);
          cells[i][j] = camera;
          cameras.add(camera);
        } else if (type == 6) {
          cells[i][j] = new Wall();
        }
      }
    }
    findMinUndarkenSpace(0);
    System.out.println(minUndarkenSpace);
  }

  private static void findMinUndarkenSpace(int depth) {
    if (depth == cameras.size()) {
      minUndarkenSpace = Math.min(minUndarkenSpace, findUndarkenSpace());
      resetCells();
      return;
    }

    Camera camera = cameras.get(depth);
    for (Direction d : typeDirections.get(camera.type - 1).directions) {
      camera.setDirection(d);
      findMinUndarkenSpace(depth + 1);
    }
  }

  private static int findUndarkenSpace() {
    for (Camera camera : cameras) {
      Direction d = camera.direction;
      int x = camera.x;
      int y = camera.y;
      if (d.right) {
        for (int i = y + 1; i < M; i++) {
          Cell cell = cells[x][i];
          if (cell instanceof Wall) {
            break;
          }
          if (cell instanceof Camera) {
            continue;
          }
          cell.isDarken = false;
        }
      }

      if (d.down) {
        for (int i = x + 1; i < N; i++) {
          Cell cell = cells[i][y];
          if (cell instanceof Wall) {
            break;
          }
          if (cell instanceof Camera) {
            continue;
          }
          cell.isDarken = false;
        }
      }

      if (d.left) {
        for (int i = y - 1; i >= 0; i--) {
          Cell cell = cells[x][i];
          if (cell instanceof Wall) {
            break;
          }
          if (cell instanceof Camera) {
            continue;
          }
          cell.isDarken = false;
        }
      }

      if (d.top) {
        for (int i = x - 1; i >= 0; i--) {
          Cell cell = cells[i][y];
          if (cell instanceof Wall) {
            break;
          }
          if (cell instanceof Camera) {
            continue;
          }
          cell.isDarken = false;
        }
      }
    }

    int darkenSize = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (cells[i][j].isDarken) {
          darkenSize++;
        }
      }
    }
    return darkenSize;
  }

  private static void resetCells() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!((cells[i][j] instanceof Camera) || (cells[i][j] instanceof Wall))) {
          cells[i][j].isDarken = true;
        }
      }
    }
  }

  static class Cell {

    public boolean isDarken;

    Cell() {
      isDarken = true;
    }
  }

  static class Camera extends Cell {

    int type;

    int x;
    int y;
    Direction direction;

    Camera(int type, int x, int y) {
      super.isDarken = false;
      this.type = type;
      this.x = x;
      this.y = y;
    }

    void setDirection(Direction direction) {
      this.direction = direction;
    }

  }

  static class Wall extends Cell {

    Wall() {
      super.isDarken = false;
    }

  }

  static class TypeDirection {

    List<Direction> directions = new ArrayList<>();

    TypeDirection(Direction... directions) {
      for (Direction d : directions) {
        this.directions.add(d);
      }
    }
  }

  static class Direction {

    boolean right;
    boolean down;
    boolean left;
    boolean top;

    Direction(boolean right, boolean down, boolean left, boolean top) {
      this.right = right;
      this.down = down;
      this.left = left;
      this.top = top;
    }
  }
}