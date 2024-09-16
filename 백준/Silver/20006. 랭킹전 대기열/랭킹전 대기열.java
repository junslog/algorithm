import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    List<Room> rooms = new ArrayList<>();
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int playerLevel = Integer.parseInt(st.nextToken());
      String playerNickname = st.nextToken();
      Room room = getAvailableRoom(rooms, playerLevel);
      if (room == null) {
        room = new Room(playerLevel);
        rooms.add(room);
      }
      room.addPlayer(new Player(playerLevel, playerNickname));
    }
    for (Room room : rooms) {
      room.printStatus();
    }
  }

  private static Room getAvailableRoom(List<Room> rooms, int playerLevel) {
    for (Room r : rooms) {
      if (r.isAvailable(playerLevel)) {
        return r;
      }
    }
    return null;
  }

  static class Room {

    int size = m;
    int initLevel;
    List<Player> players = new ArrayList<>();

    Room(int initLevel) {
      this.initLevel = initLevel;
    }

    void addPlayer(Player player) {
      this.players.add(player);
    }

    boolean isFull() {
      return size == players.size();
    }

    boolean isAvailable(int playerLevel) {
      return (!isFull()) && (Math.abs(playerLevel - this.initLevel) <= 10);
    }

    void printStatus() {
      if (isFull()) {
        System.out.println("Started!");
      } else {
        System.out.println("Waiting!");
      }
      Collections.sort(players);
      for (Player p : players) {
        System.out.println(p.level + " " + p.nickname);
      }
    }
  }

  static class Player implements Comparable<Player> {

    int level;
    String nickname;

    Player(int level, String nickname) {
      this.level = level;
      this.nickname = nickname;
    }

    public int compareTo(Player other) {
      return this.nickname.compareTo(other.nickname);
    }
  }
}
