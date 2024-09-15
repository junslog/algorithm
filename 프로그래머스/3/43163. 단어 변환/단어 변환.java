import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
    
        int wordLen = words.length;
        visited = new boolean[wordLen];
        
        Queue<ConvertedWord> q = new LinkedList<>();
        q.add(new ConvertedWord(begin, 0));
        int answer = 0;
        while(!q.isEmpty()){
            ConvertedWord cw = q.poll();
            if(cw.content.equals(target)){
                answer = cw.step;
                break;
            }
            for(int i = 0; i < wordLen; i++){
                if(visited[i]){
                    continue;
                }
                if(canConvert(cw.content, words[i])){
                    visited[i] = true;
                    q.add(new ConvertedWord(words[i], cw.step + 1));
                }
            }
        }
        return answer;
    }
    
    static class ConvertedWord{
        String content;
        int step;
        
        ConvertedWord(String content, int step){
            this.content = content;
            this.step = step;
        }
    }
    
    private static boolean canConvert(String fromStr, String toStr){
        int diffCount = 0;
        int strSize = fromStr.length();
        for(int i = 0; i < strSize; i++){
            if(!(fromStr.charAt(i) == toStr.charAt(i))){
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}