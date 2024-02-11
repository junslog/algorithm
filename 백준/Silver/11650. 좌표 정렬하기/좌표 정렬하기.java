import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        List<Point> sortedPoints = pointList.stream()
                .sorted()
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sortedPoints.size(); i++){
            sb.append(sortedPoints.get(i).toString()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p){
            if(x == p.x){
                return y - p.y;
            }
            return x - p.x;
        }

        @Override
        public String toString(){
            return x + " " + y;
        }
    }
}