import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, Integer> sToInt = new HashMap<>();
        String[] ss = {"zero", "one", "two", "three", "four", 
                       "five", "six", "seven", "eight", "nine"};
        List<String> numbers = List.of(new String[]{"0", "1", "2", "3", "4",
                           "5", "6", "7", "8", "9"});
        
        for(int i = 0; i <= 9; i++){
            sToInt.put(ss[i], i);
        }
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