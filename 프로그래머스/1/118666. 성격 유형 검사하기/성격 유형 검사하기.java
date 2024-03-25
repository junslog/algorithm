import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // R, T
        // C, F
        // J, M
        // A, N
        // survey[i][0] : 비동의, survet[i][1] : 동의
        // choices[0] : 1 => 매우 비동의
        // choices[6] : 7 => 매우 동의
        int sLen = survey.length;
        // surveys[i][0] : 비동의 관련 시, 점수 올라감 ( choices : 1 ~ 3 => 3점 ~ 1점)
        // surveys[i][1] : 동의 관련 시, 점수 올라감 ( choices : 5 ~ 7 => 1점 ~ 3점 )
        String[][] surveys = new String[sLen][2];
        for(int i = 0; i < sLen; i++){
            String[] sInput = survey[i].split("");
            surveys[i][0] = sInput[0];
            surveys[i][1] = sInput[1];
        }
        
        Map<String, Integer> typeToScore = new HashMap<>();
        String[] characterType = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(int i = 0; i < 8; i++){
            typeToScore.put(characterType[i], 0);
        }
        
        for(int i = 0; i < sLen; i++){
            String notAgree = surveys[i][0];
            String agree = surveys[i][1];
            int choice = choices[i];
            if(choice >= 1 && choice <= 3){
                typeToScore.put(notAgree, typeToScore.get(notAgree) + (4 - choice));
            }
            if(choice >= 5 && choice <= 7){
                typeToScore.put(agree, typeToScore.get(agree) + (choice - 4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(typeToScore.get("R") >= typeToScore.get("T") ? "R" : "T");
        sb.append(typeToScore.get("C") >= typeToScore.get("F") ? "C" : "F");
        sb.append(typeToScore.get("J") >= typeToScore.get("M") ? "J" : "M");
        sb.append(typeToScore.get("A") >= typeToScore.get("N") ? "A" : "N");
        return sb.toString();
    }
}