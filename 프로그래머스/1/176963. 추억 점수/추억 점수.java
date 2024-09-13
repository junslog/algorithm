import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> yPoint = new HashMap<>();
        int size = name.length;
        for(int i = 0; i < size; i++){
            yPoint.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            String[] currPhoto = photo[i];
            for(String n : currPhoto){
                answer[i] += yPoint.getOrDefault(n, 0);
            }
        }
        return answer;
    }
}