import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] array, int n) {
        int[] absMinus = new int[array.length];
        for(int i = 0; i < absMinus.length; i++){
            absMinus[i] = Math.abs(array[i] - n);
        }
        Arrays.sort(absMinus);
        int minimumAbsMinus = absMinus[0];
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(Math.abs(array[i] - n) == minimumAbsMinus){
                values.add(array[i]);
            }
        }
        Collections.sort(values);
        return values.get(0);
    }
}