import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int hamburger = 0;
        int ingSize = ingredient.length;
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < ingSize; i++){
            s.push(ingredient[i]);
            if(s.size() >= 4){
                if(s.get(s.size() - 1) == 1
                   && s.get(s.size() - 2) == 3
                   && s.get(s.size() - 3) == 2
                   && s.get(s.size() - 4) == 1){
                    for(int j = 0; j < 4; j++){
                        s.pop();
                    }
                    hamburger++;
                }
            }
        }
        return hamburger;
    }
}