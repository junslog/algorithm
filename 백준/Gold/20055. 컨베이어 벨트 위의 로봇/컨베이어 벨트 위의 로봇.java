import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int K;
  static int T;
  static int cursor;
  static int downIdx;

  static Belt[] belts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    T = 0;
    cursor = 0;

    // 벨트 배열 초기화
    belts = new Belt[2 * N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * N; i++) {
      belts[i] = new Belt(Integer.parseInt(st.nextToken()));
    }

    do {
      // 1. 커서 이동
      updateCursor();

      // 2. 로봇 각각 이동
      moveRobots();

      // 3. 올리는 위치에 로봇 올리기
      makeRobotOnStartPoint();

      T++;
    } while (isValidChain()); // 4. 내구도 체크

    System.out.println(T);
  }

  private static void updateCursor() {
    if ((T + 1) % (2 * N) == 0) {
      cursor = 0;
      downIdx = N - 1;
    } else {
      cursor = 2 * N - ((T + 1) % (2 * N));
      downIdx = (cursor + N - 1) % (2 * N);
    }
    Belt downBelt = belts[downIdx];
    if (downBelt.hasRobot()) {
      downBelt.leaveRobot();
    }
  }

  private static boolean isValidChain() {
    int brokenBeltCount = 0;
    for (int i = 0; i < 2 * N; i++) {
      if (belts[i].isBroken()) {
        brokenBeltCount++;
      }
    }
    return brokenBeltCount < K;
  }

  private static void moveRobots() {
    boolean[] currentlyMoved = new boolean[2 * N];
    while (true) {
      int diffCnt = 0;
      for (int i = 0; i < 2 * N; i++) {
        if (belts[i].hasRobot()) {
          int nextBeltIdx = (i + 1) % (2 * N);
          if (belts[nextBeltIdx].hasRobot() || belts[nextBeltIdx].isBroken()
              || currentlyMoved[i]) {
            continue;
          }
          belts[i].leaveRobot();
          diffCnt++;
          belts[nextBeltIdx].loadRobot();
          currentlyMoved[nextBeltIdx] = true;
          if (nextBeltIdx == downIdx) {
            belts[nextBeltIdx].leaveRobot();
            currentlyMoved[nextBeltIdx] = false;
          }
        }
      }
      if (diffCnt == 0) {
        break;
      }
    }
  }

  private static void makeRobotOnStartPoint() {
    Belt startPointBelt = belts[cursor];
    if (!startPointBelt.hasRobot() && !startPointBelt.isBroken()) {
      startPointBelt.loadRobot();
    }
  }

  static class Belt {

    int endurance;
    boolean hasRobot;

    Belt(int endurance) {
      this.endurance = endurance;
      this.hasRobot = false;
    }

    boolean hasRobot() {
      return this.hasRobot;
    }

    boolean isBroken() {
      return this.endurance == 0;
    }

    void loadRobot() {
      this.endurance -= 1;
      this.hasRobot = true;
    }

    void leaveRobot() {
      this.hasRobot = false;
    }
  }

}