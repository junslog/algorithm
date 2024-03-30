import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        
        Map<String, Integer> sToInt = new HashMap<>();
        String[] ss = {"zero", "one", "two", "three", "four", 
                       "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i <= 9; i++){
            sToInt.put(ss[i], i);
        }
        
        String[] nums = {"0", "1", "2", "3", "4",
                           "5", "6", "7", "8", "9"};
        List<String> numbers = Arrays.stream(nums).collect(Collectors.toList());
        
        
        String[] items = s.split("");
        int itemsLen = items.length;
        int runner = 0;
        StringBuilder sb = new StringBuilder();
        String val = "";
        while(runner < itemsLen){
            if(numbers.contains(items[runner])){
                sb.append(items[runner++]);
                continue;
            }
            val += items[runner++];
            if(sToInt.getOrDefault(val, -1) != -1){
                sb.append(sToInt.get(val));
                val = "";
            }
        }
        return Integer.parseInt(sb.toString());
    }
}